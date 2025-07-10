import React, { useState } from "react";
import { forgotPassword } from "../services/authService";

export default function ForgotPassword() {
    const [email, setEmail] = useState("");
    const [message, setMessage] = useState("");
    const [error, setError] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await forgotPassword(email);
            setMessage("Revisa tu correo para restablecer la contraseña");
            setError("");
        } catch (err) {
            setError("Error al enviar correo");
            setMessage("");
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Recuperar Contraseña</h2>
            <input
                type="email"
                placeholder="Correo"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
            />
            {message && <p style={{ color: "green" }}>{message}</p>}
            {error && <p style={{ color: "red" }}>{error}</p>}
            <button type="submit">Enviar correo</button>
        </form>
    );
}
