package br.com.zup.clientes

class Cliente(
    val nome: String,
    val email: String
) {
    override fun toString(): String {
        return "Cliente(nome='$nome', email='$email')"
    }
}
