import Header from "../../components/Header";
import Footer from "../../components/Footer";
import Info from "../Info/Info";
import Services from "../Services/Services";
import AboutUs from "../About/About";
import Contact from "../Contact/Contact";

function Home() {
  return (
    <>
      <Header />
      <div className="home">
        <div className="home-text">
          <h1>Encontre o melhor autocenter para sua necessidade.</h1>
          <p>
            De troca de óleos a reparos e customizações, agende e confirme tudo
            no conforto da sua casa.
          </p>
          <a>Veja os serviços</a>
        </div>
        <img src="../src/assets/home.png" alt="" />
      </div>

      <Info />
      <Services />
      <AboutUs />
      <Contact />
      <Footer />
    </>
  );
}

export default Home;
