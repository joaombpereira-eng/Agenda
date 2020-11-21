package repository

import entity.contactEntity

class contactRepository {

    companion object {
        private val contactList = mutableListOf<contactEntity>()

        fun save(contact: contactEntity) {
            contactList.add(contact)
        }

        fun delete(contact: contactEntity) {

        }

        fun getList(): List<contactEntity> {
            return contactList
        }
    }
}