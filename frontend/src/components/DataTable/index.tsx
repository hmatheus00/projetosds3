import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

function Datatable() {
    
    const [activePage, setActivePage] = useState(0);
    const [page, setPage] = useState<SalePage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });

    useEffect(() => {
        
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
            .then(
                res => {
                    setPage(res.data);
                }
            )}, [activePage]);
    
    const changePage = (index: number)=>{
        setActivePage(index)
    }
    
    
    return (
        <>
            <Pagination page= {page} onPageChange= {changePage} />
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Vendedor</th>
                            <th>Clientes visitados</th>
                            <th>Negócios fechados</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        {page.content?.map(obj => (
                            <tr key={obj.id}>
                                <td>{formatLocalDate(obj.date, 'dd/MM/yyyy')}</td>
                                <td>{obj.seller.name}</td>
                                <td>{obj.visited}</td>
                                <td>{obj.deals}</td>
                                <td>{obj.amount.toFixed(2)}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default Datatable;