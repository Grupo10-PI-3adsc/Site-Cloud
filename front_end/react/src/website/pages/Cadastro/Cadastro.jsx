function Cadastrar() {
    return (
        <>
            <div className="register">
                <div className="register-container">
                    <div className="register-contents">
                        <div className="register-titles">
                            <h1>Crie uma conta nova<a>!</a></h1>
                            <p>Já possui conta? <a href="#">Faça Login</a> </p>
                        </div>
                        <div className="register-inputs">
                            <div className="register-inputs-names">
                                <div className="input-container">
                                    <label htmlFor="inputField">Nome</label>
                                    <input type="text" id="inputField" />
                                </div>
                                <div className="input-container">
                                    <label htmlFor="inputField">Sobrenome</label>
                                    <input type="text" id="inputField" />
                                </div>
                            </div>

                            <div className="input-container">
                                <label htmlFor="inputField" className="focus">CPF</label>
                                <input type="text" id="inputField" />
                            </div>
                            <div className="input-container">
                                <label htmlFor="inputField">E-mail</label>
                                <input type="text" id="inputField" />
                            </div>
                            <div className="input-container">
                                <label htmlFor="inputField">Senha</label>
                                <input type="text" id="inputField" />
                            </div>
                        </div>
                        <button className="btn-register">Prosseguir</button>
                    </div>

                    <div className="login-contents">
                        <div className="login-titles">
                            <h1>Entre na sua conta<a>!</a></h1>
                            <p>Não tem conta? <a href="#">Cadastre-se!</a> </p>
                        </div>
                        <div className="login-inputs">
                            <div className="input-container">
                                <label htmlFor="inputField">Nome</label>
                                <input type="text" id="inputField" />
                            </div>
                            <div className="input-container">
                                <label htmlFor="inputField">Sobrenome</label>
                                <input type="text" id="inputField" />
                            </div>
                        </div>
                        <button className="btn-login">Prosseguir</button>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Cadastrar;