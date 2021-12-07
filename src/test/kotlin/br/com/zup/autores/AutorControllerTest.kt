package br.com.zup.autores

import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import io.micronaut.http.client.HttpClient
import io.micronaut.test.annotation.MockBean
import org.mockito.Mockito

@MicronautTest
internal class AutorControllerTest {

    @field: Inject
    lateinit var autorRepository: AutorRepository

    //mock de um client externo
    @field: Inject
    lateinit var enderecoClient: EnderecoClient

    @field: Inject
    @field: Client("/")
    lateinit var client: HttpClient

    lateinit var autor: Autor

    @BeforeEach
    internal fun setup(){
        //setup do banco insere as informações
        autor = Autor("Diogo Magliano", "diogo.magliano@gmail.com", "Autor de livros obscuros")
        autorRepository.save(autor)
    }

    @AfterEach
    internal fun tearDown(){
        //deleta as entradas no banco.
    }

    @Test
    internal fun `deve buscar um autor quando email valido é encontrado`() {

        val response = client.toBlocking().exchange("/autores?email=${autor.email}", AutorDetalhesDto::class.java)

        //Mockito.`when`(enderecoClient).thenReturn(/*resposta*/)


        //faz os assertions
        //assertEquals()
        //assertNotNull()
    }

    @MockBean(EnderecoClient::class) //define a classe do bean do mock
    fun enderecoMock(): EnderecoClient {
        return Mockito.mock(EnderecoClient::class.java)
    }

}