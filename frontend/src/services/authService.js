import axios from "axios";

const API_URL = "http://localhost:8080/api/auth"; // Cambia si usas otro puerto/backend

export const login = (email, password) => {
    return axios.post(`${API_URL}/login`, { email, password });
};
export const register = (userData) => {
    // userData debe ser un objeto con los campos que pide tu backend para registro
    return axios.post(`${API_URL}/register`, userData);
};

export const forgotPassword = (email) => {
    return axios.post(`${API_URL}/forgot-password`, { email });
};
