import axios from "axios";

const API_URL = "http://localhost:8080/api/auth"; // Cambia si usas otro puerto/backend path

export const login = (email, password) => {
    return axios.post(`${API_URL}/login`, { email, password });
};

export const register = (email, password) => {
    return axios.post(`${API_URL}/register`, { email, password });
};

export const forgotPassword = (email) => {
    return axios.post(`${API_URL}/forgot-password`, { email });
};
