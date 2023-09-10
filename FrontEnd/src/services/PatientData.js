import http from '../httpCommon';

export default({

    create(PatientData){
        return http.post(`/patients`, PatientData);
    },

    getAll(params) {
        return http.get(`/patients`, { params });
    },
      
    getById(PatientID) {
        return http.get(`/patients/${PatientID}`);
    },
    
    update(PatientID, PatientData) {
        return http.put(`/patients/update/${PatientID}`, PatientData);
    },
    
    delete(PatientID) {
        return http.delete(`/patients/delete/${PatientID}`);
    }
});
