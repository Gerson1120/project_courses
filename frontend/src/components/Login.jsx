import React, { useState } from "react";
import { login } from "../services/authService";
import { useNavigate } from "react-router-dom";

export default function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await login(email, password);
            // Guarda el token o info según tu backend
            localStorage.setItem("token", response.data.token);
            navigate("/dashboard"); // O a donde quieras ir
        } catch (err) {
            setError("Credenciales inválidas");
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Iniciar Sesión</h2>
            <input
                type="email"
                placeholder="Correo"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
            />
            <input
                type="password"
                placeholder="Contraseña"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
            />
            {error && <p style={{ color: "red" }}>{error}</p>}
            <button type="submit">Entrar</button>
            <p>
                ¿No tienes cuenta? <a href="/register">Regístrate</a>
            </p>
            <p>
                <a href="/forgot-password">¿Olvidaste tu contraseña?</a>
            </p>
        </form>
    );
}
