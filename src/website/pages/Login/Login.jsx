import React, { useState } from 'react';
import { Link, useNavigate } from "react-router-dom";
import Header from "../../components/Header";

function Login() {
    const navigate = useNavigate();

    const handleRegisterClick = (path) => {
        navigate(path);
    };

    const [showEmailLabel, setShowEmailLabel] = useState(true);
    const [showPasswordLabel, setShowPasswordLabel] = useState(true);
    const [email, setEmail] = useState("");
    const [password, setSenha] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        const data = {
            email,
            password
        };

        try {
            const response = await fetch(`http://localhost:8080/auth/login`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                alert("Login realizado com sucesso!");
                navigate("/");
            } else {
                alert("Falha no login");
            }
        } catch (error) {
            console.error("Erro ao enviar dados:", error);
        }
    }

    return (
        <>
        <Header/>
        <div className="auth-page">
            <div className="auth-container">
                <div className="auth-contents">
                    <div className="auth-titles">
                        <h1>Entre na sua conta<a>!</a></h1>
                        <p>Não tem conta? <a href="#" onClick={() => handleRegisterClick("/cadastro")}>Cadastre-se!</a></p>
                    </div>
                    <form onSubmit={handleSubmit} className="auth-inputs">
                        <div className="input-container">
                            {showEmailLabel && <label htmlFor="email">E-mail</label>}
                            <input 
                                type="text" 
                                id="email" 
                                value={email} 
                                onChange={(e) => setEmail(e.target.value)} 
                                onFocus={() => setShowEmailLabel(false)} 
                                onBlur={() => setShowEmailLabel(!email)} 
                            />
                        </div>
                        <div className="input-container">
                            {showPasswordLabel && <label htmlFor="senha">Password</label>}
                            <input 
                                type="password" 
                                id="senha" 
                                value={password} 
                                onChange={(e) => setSenha(e.target.value)} 
                                onFocus={() => setShowPasswordLabel(false)} 
                                onBlur={() => setShowPasswordLabel(!password)} 
                            />
                            <div className="auth-titles">
                                <p>Esqueceu sua senha? <a href="#" onClick={() => handleRegisterClick("/recuperar-senha")}>Recuperar Senha</a></p>
                            </div>
                        </div>
                        <button className="auth-btn" type="submit">Prosseguir</button>
                    </form>
                </div>
            </div>
        </div>
        </>
    );
}

export default Login;
