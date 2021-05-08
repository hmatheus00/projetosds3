import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SuccessSale } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type seriesData = {
    name: string,
    data: number[]
}

type ChartData = {
    labels: {categories: string[]};
    series: seriesData[];
}

function Barchart (){
    
    const [chartData, setChartData] = useState<ChartData>({labels: {categories: []}, series: [{name: "", data: []}]});

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/sale-by-seller`)
            .then(res => {
                const data = res.data as SuccessSale[];

                const myLabels = data.map( x => x.sellerName);
                const mySeries = data.map( y => round(100*(y.deals / y.visited), 2));

                setChartData({labels: {categories: myLabels}, series: [{name: "% Sucesso", data: mySeries}]})
            })
    }, [])

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
/* 
    const mockData = {
        labels: {
            categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
        },
        series: [
            {
                name: "% Sucesso",
                data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
            }
        ]
    };
*/    
    return (
        <Chart 
            options={{...options, xaxis: chartData.labels}}
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}

export default Barchart;