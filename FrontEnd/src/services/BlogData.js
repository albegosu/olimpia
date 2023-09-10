import http from '../httpCommon';

export default({

    create(BlogData){
        return http.post(`/post`, BlogData);
    },

    getAll(params) {
        return http.get(`/post`, { params });
    },
      
    getById(PostId) {
        return http.get(`/post/${PostId}`);
    },
    
    update(PostId, BlogData) {
        return http.put(`/post/update/${PostId}`, BlogData);
    },
    
    delete(PostId) {
        return http.delete(`/post/delete/${PostId}`);
    }
});
