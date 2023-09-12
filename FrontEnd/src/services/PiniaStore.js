import { defineStore } from 'pinia';

export const usePatientDataStore = defineStore('patientData', {
  state: () => ({
    patientList: [{
      patientName: '',
      patientLastName: '',
      age: '',
      consultationDate: '',
      painType: '',
      description: ''
    }],
  }),
  actions: {
    setPatientData(data) {
      this.patientList = data; // Usa this.state para acceder al estado
    },
  },
  getters: {
    getPatientDataList() {
      return this.patientList; // Usa this.state para acceder al estado
    },
  },
});