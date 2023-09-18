import http from '../httpCommon';

export default({
    create(formData){
        return http.post(`/enviar-formulario`, formData);
    }
})