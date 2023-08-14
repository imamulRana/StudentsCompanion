package com.imstudio.studentscompanion.ui.components.modifiers

/*
fun setDept(newDept: String) {
    setDept.value = newDept
}

fun updateScreen(dept: String) {
    dbRef.collection("students_companion").document(dept)
        .get()
        .addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                documentSnapshot?.data ?: emptyMap()
            }
        }
        .addOnFailureListener { exception ->
            setDept.value = exception.cause.toString()
        }
}
    private fun getDataDate() {
        viewModelScope.launch(Dispatchers.IO) {
            colRef.addSnapshotListener { documents, _ ->
                val newList = documents?.toObjects(ClassItem::class.java)
                _classItems.value = newList!!
            }
        }
    }


setData(
            days = Days(
                listOf(
                    ClassItem(),
                    ClassItem(),
                    ClassItem(),
                )
            )
        )



setData(
            listOf(
                "50",
                "51",
                "52",
                "53",
                "54",
                "55",
                "56",
                "57",
                "58",
                "59",
                "60"
            ),
            days = listOf("monday", "tuesday", "wednesday", "thursday")
        )

val data = Days(
        classDays = listOf(
            ClassItem(), ClassItem(),
            ClassItem(), ClassItem()
        )
    )

    private fun setData(batches: List<String>, days: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            for (batch in batches) {
                for (day in days) {
                    dbRef.collection("department").document("cse")
                        .collection("batch")
                        .document(batch).collection("section")
                        .document("a").collection("day").document(day)
                        .set(data)
                }
            }
        }
    }
val data = ClassItemList(
    classItemList = listOf(
        ClassItem(), ClassItem(),
        ClassItem(), ClassItem()
    )
)

val batchList = listOf("50", "51", "52", "53")
val sectionsList = listOf("a", "b", "c")
val dayList = listOf("monday", "tuesday", "wednesday", "thursday")

fun setDataWithParam() {
    viewModelScope.launch(Dispatchers.IO) {
        for (batch in batchList) {
            for (section in sectionsList) {
                for (days in dayList) {
                    dbRef.collection("department")
                        .document("cse").collection("batch")
                        .document(batch).collection("section")
                        .document(section).collection("day")
                        .document(days)
                        .set(data, SetOptions.merge())
                }
            }
        }
    }
}


    init {
        setDataWithParam()
    }
 */
