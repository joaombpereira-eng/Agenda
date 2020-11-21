package business

import entity.contactEntity
import repository.contactRepository

class contactBusiness {

    private fun validate(name: String, phone: String) {
        if (name == "")
            throw Exception("Nome é obrigatório!")
        if (phone == "")
            throw Exception("Telefone é obrigatório!")
    }

    private fun validateDelete(name: String, phone: String) {
        if (name == "" && phone == "")
            throw Exception("É necessário selecionar um contacto antes de remover.")
    }

    fun getContactCountDescription(): String {
        val list = getList()
        return when {
            list.isEmpty() -> "0 contactos"
            list.size == 1 -> "1 contacto"
            else -> "${list.size} contactos"
        }
    }

    fun save(name: String, phone: String) {
        validate(name, phone)
        val contact = contactEntity(name, phone)
        contactRepository.save(contact)
    }

    fun delete(name: String, phone: String) {
        validateDelete(name, phone)
        val contact = contactEntity(name, phone)
        contactRepository.delete(contact)
    }

    fun getList(): List<contactEntity> {
        return contactRepository.getList()
    }
}