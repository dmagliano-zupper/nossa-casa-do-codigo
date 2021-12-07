package br.com.zup.autores

import br.com.zup.livros.Livro
import br.com.zup.livros.LivroRepository
import br.com.zup.livros.LivrosRequestDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Controller("/autores")
class AutorController(
    val autorRepository: AutorRepository,
    val livroRepository: LivroRepository
) {
    val logger: Logger? = LoggerFactory.getLogger(this.javaClass)

    @Post
    fun cadastra(@Body request: NovoAutorRequest): HttpResponse<Any> {
        logger?.debug(request.toString())
        autorRepository.save(request.toAutor())
        cadastroLivros(request.livros, livroRepository)
        return HttpResponse.created(request)
    }

    @Get
    fun lista(): HttpResponse<List<AutorDetalhesDto>> {
        return HttpResponse.ok(autorRepository.listAll())
    }

    fun cadastroLivros(livros: List<LivrosRequestDto>, livroRepository: LivroRepository) {
        livros.map(LivrosRequestDto::toLivro)
            .also { list: List<Livro> -> list.forEach { livro -> livroRepository.save(livro) } }
    }


}