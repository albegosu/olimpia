// TokenStore.js
import { defineStore } from 'pinia';

const useTokenStore = defineStore('token', {
  state: () => ({
    token: null,
  }),
  actions: {
    setToken(token) {
      this.token = token;
    },
    clearToken() {
      this.token = null;
    },
  },
  getters: {
    isAuthenticated() {
      return !!this.token;
    },
  },
});

export default useTokenStore; // Exporta el store como valor predeterminado
