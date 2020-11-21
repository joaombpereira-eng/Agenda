package repository

import entity.contactEntity

class contactRepository {

    companion object {
        private val contactList = mutableListOf<contactEntity>()

        fun save(contact: contactEntity) {
            contactList.add(contact)
        }

        fun delete(contact: contactEntity) {
            var index = 0

            for (item in contactList.withIndex()) {
                if (item.value.name == contact.name && item.value.phone == contact.phone) {
                    index = item.index
                    break
                }
            }
            contactList.removeAt(index)
        }

        fun getList(): List<contactEntity> {
            return contactList
        }
    }
}