function Header() {

    return (
        <header className="header">
            <img src="../src/assets/lotus-icon.png" alt="" />
            <nav className="nav-bar">
                <a href="#">Principal</a>
                <a href="#">Sobre</a>
                <a href="#">Serviços</a>
                <a href="#">Contato</a>

                <hr />

                <a href="#">Cadastrar</a>
                <a className="login-btn">Login</a>
            </nav>
        </header>
    );
}

export default Header;