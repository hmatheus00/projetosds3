import Barchart from 'components/Barchart';
import Datatable from 'components/DataTable';
import Donutcharts from 'components/Donutchart';
import Footer from 'components/Footer';
import Navbar from 'components/Navbar';

function App() {
  return (
      <>
      <Navbar />
      <div className="container">
        <div className="row px-3">
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Porcentagem de sucesso</h5>
            <Barchart />
          </div>
          <div className="col-sm-6">
            <h5>Listagem de vendas</h5>
            <Donutcharts />
          </div>
        </div>

        <div className="py-3">
          <h2 className="text-primary">Total de vendas</h2>
        </div>
        <Datatable />
      </div>
      <Footer />
      </>
  );
}

export default App;