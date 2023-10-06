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

    //    var expanded by remember {
//        mutableStateOf(false)
//    }
//
//    ExposedDropdownMenuBox(
//        expanded = expanded, onExpandedChange = { expanded = !expanded },
//        modifier = modifier
//            .padding(horizontal = Padding.mediumPadding)
//    ) {
//        TextField(
//            value = currentDept.department,
//            onValueChange = { currentDept.department },
//            modifier = modifier
//                .menuAnchor()
//                .fillMaxWidth(),
//            readOnly = true,
//            trailingIcon = {
//                if (expanded) {
//                    Icon(
//                        imageVector = Icons.Rounded.KeyboardArrowUp,
//                        contentDescription = ""
//                    )
//                } else Icon(imageVector = Icons.Rounded.KeyboardArrowDown, contentDescription = "")
//            },
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = MaterialTheme.colorScheme.primary,
//                unfocusedIndicatorColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent
//            ),
//            shape = MaterialTheme.shapes.medium,
//            placeholder = { Text(text = "Department") }
//        )
//        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//            departmentState.forEach {
//                DropdownMenuItem(
//                    text = { Text(text = it.department) },
//                    onClick = {
//                        currentDept = it
//                        studentsCompanionViewModel.getBatchByDept(
//                            deptId = currentDept.id,
//                            dept = currentDept.department
//                        )
//                        expanded = !expanded
//                    }
//                )
//            }
//        }
//    }
 */
