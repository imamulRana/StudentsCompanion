package com.imstudio.studentscompanion.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.imstudio.studentscompanion.model.BusScheduleItemList
import com.imstudio.studentscompanion.model.ClassItemList
import com.imstudio.studentscompanion.model.LoginUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StudentsCompanionViewModel : ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    //
    private val _classItemListState = MutableStateFlow<List<ClassItemList>>(listOf())
    val classItemListState: StateFlow<List<ClassItemList>> = _classItemListState.asStateFlow()

    //
    private val _departments = MutableStateFlow<List<String>>(listOf())
    val departments: StateFlow<List<String>> = _departments.asStateFlow()

    //
    private val _batches = MutableStateFlow<List<String>>(listOf())
    val batches: StateFlow<List<String>> = _batches.asStateFlow()

    //
    private val _sections = MutableStateFlow<List<String>>(listOf())
    val sections: StateFlow<List<String>> = _sections.asStateFlow()

    //
    private val _classDateState = MutableStateFlow<List<String>>(listOf())
    val classDateState: StateFlow<List<String>> = _classDateState.asStateFlow()

    //
    private val _busScheduleItemListState = MutableStateFlow<List<BusScheduleItemList>>(listOf())
    val busScheduleItemListState: StateFlow<List<BusScheduleItemList>> =
        _busScheduleItemListState.asStateFlow()

    //
    private val _busUpDateState = MutableStateFlow<List<String>>(listOf())
    val busUpDateState: StateFlow<List<String>> = _busUpDateState.asStateFlow()

    //
    // BUS UI State
    private val _busScheduleItemListStateDn = MutableStateFlow<List<BusScheduleItemList>>(listOf())
    val busScheduleItemListStateDn: StateFlow<List<BusScheduleItemList>> =
        _busScheduleItemListStateDn.asStateFlow()

    //
    private val _busUpDateStateDn = MutableStateFlow<List<String>>(listOf())
    val busUpDateStateDn: StateFlow<List<String>> = _busUpDateStateDn.asStateFlow()

    //
    private val dbRef = Firebase.firestore
    private val busUpDbRef = dbRef.collection("bus")
        .document("up")
        .collection("day")
    private val busDnDbRef = dbRef.collection("bus")
        .document("down")
        .collection("day")
    //

    //For Updating The Values Of LazyVertical Grid And LazyRows
    fun updateDepartment(
        newDepartment: String
    ) {
        _loginUiState.update { loginUiState ->
            loginUiState.copy(department = newDepartment, batch = "", section = "")
        }
    }

    fun updateBatch(newBatch: String) {
        _loginUiState.update { loginUiState ->
            loginUiState.copy(batch = newBatch, section = "")
        }
    }

    fun updateSection(newSection: String) {
        _loginUiState.update { loginUiState ->
            loginUiState.copy(section = newSection)
        }
    }

    //Gets The Department ID
    val depRef = dbRef.collection("department")
        .addSnapshotListener { documents, _ ->
            val new = documents?.documents?.map { documentSnapshot ->
                documentSnapshot.id
            }
            _departments.getAndUpdate { new ?: listOf() }
        }


    //Gets The Batch Document ID based on Department Input
    fun batchRef(inputDept: String) {
        viewModelScope.launch {
            dbRef.collection("department")
                .document(inputDept).collection("batch")
                .addSnapshotListener { documents, _ ->
                    val new = documents?.documents?.map { documentSnapshot ->
                        documentSnapshot.id
                    }
                    _batches.update {
                        new ?: listOf()
                    }
                }
        }
    }

    //Gets The Section Document ID based on Batch Input
    fun secRef(inputBatch: String) {
        viewModelScope.launch {
            dbRef.collection("department")
                .document(_loginUiState.value.department).collection("batch")
                .document(inputBatch).collection("section")
                .addSnapshotListener { documents, _ ->
                    val new = documents?.documents?.map { documentSnapshot ->
                        documentSnapshot.id
                    }
                    _sections.update {
                        new ?: listOf()
                    }
                }
        }
    }


    //Gets The Class Schedules Based on The Input Parameters
    fun getClassSchedules() {
        viewModelScope.launch(Dispatchers.IO) {
            val newDbRef = dbRef.collection("department")
                .document(_loginUiState.value.department)
                .collection("batch")
                .document(_loginUiState.value.batch)
                .collection("section").document(_loginUiState.value.section)
                .collection("day")
            newDbRef.get().addOnSuccessListener { documents ->
                val newList = documents?.toObjects(ClassItemList::class.java)
                _classItemListState.update {
                    newList ?: listOf()
                }
            }
            newDbRef.get().addOnSuccessListener { document ->
                val datesList = document?.documents?.map { documentSnapshot ->
                    documentSnapshot.id
                }
                _classDateState.update {
                    datesList ?: listOf()
                }
            }
        }
    }

    //SECTION FOR BUS DATA
    //Bus Schedules
    fun getUpBusData() {
        viewModelScope.launch(Dispatchers.IO) {
            busUpDbRef.get().addOnSuccessListener { documents ->
                val busUpDataList = documents?.toObjects(BusScheduleItemList::class.java)
                _busScheduleItemListState.update {
                    busUpDataList ?: listOf()
                }
            }
        }
    }

    fun getUpBusDates() {
        viewModelScope.launch(Dispatchers.IO) {
            busUpDbRef.get().addOnSuccessListener { documents ->
                val busUpDates = documents?.documents?.map { documentSnapshot ->
                    documentSnapshot.id
                }
                _busUpDateState.update {
                    busUpDates ?: listOf()
                }
            }
        }
    }

    fun getDnBusData() {
        viewModelScope.launch(Dispatchers.IO) {
            busDnDbRef.get().addOnSuccessListener { documents ->
                val busDnDataList = documents?.toObjects(BusScheduleItemList::class.java)
                _busScheduleItemListStateDn.update {
                    busDnDataList ?: listOf()
                }
            }
        }
    }

    fun getDnBusDates() {
        viewModelScope.launch {
            busDnDbRef.get().addOnSuccessListener { documents ->
                val busDnDates = documents?.documents?.map { documentSnapshot ->
                    documentSnapshot.id
                }
                _busUpDateStateDn.update {
                    busDnDates ?: listOf()
                }
            }
        }
    }

    //Logout
    fun resetAll() {
        //Reset Everything Without Dept Because It Initializes First
        _batches.update {
            listOf()
        }
        _sections.update {
            listOf()
        }
        _loginUiState.update { loginUiState ->
            loginUiState.copy(department = "", batch = "", section = "")
        }

    }
}
