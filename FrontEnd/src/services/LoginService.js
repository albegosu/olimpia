// loginService.js
import http from '../httpLogin'; // Importa el cliente HTTP común
import useTokenStore from '@/services/TokenStore.js'; // Importa el TokenStore

const tokenStore = useTokenStore; // Accede al TokenStore

const login = async (email, password) => {
  try {
    const credentials = {
      email: email,
      password: password
    };

    const response = await http.post('/api/v1/auth/signin', credentials); // Utiliza el cliente HTTP común

    const token = response.data.token;

    // Almacena el token en el TokenStore
    tokenStore.setToken(token);

    return token;
  } catch (error) {
    throw error;
  }
};

export default {
  login
};
