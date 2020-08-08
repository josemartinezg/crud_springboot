<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Carrto Flia. Martinez Garcia</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <link href="/css/sb-admin.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<#--    Navbar   -->
<#include "navbar.ftl">
<#include "sidenav.ftl">
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/js/scripts.js"></script>
<script src="/js/home.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="/js/demo/chart-area-demo.js"></script>
<script>
    // Set new default font family and font color to mimic Bootstrap's default styling
    Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#292b2c';

    // Bar Chart Example
    var ctx = document.getElementById("myBarChart");
    var myLineChart = new Chart(ctx, {
        type: 'bar',
        data: {
            /*Arreglo de  nombres de subfamilias*/
            labels: [<#list chartLabels as label>${label},</#list>],
            datasets: [{
                label: "Revenue",
                backgroundColor: "rgba(2,117,216,1)",
                borderColor: "rgba(2,117,216,1)",
                /*Arreglo de dias por subfamilia*/
                data: [<#list chartData as data>${data},</#list>],
            }],
        },
        options: {
            scales: {
                xAxes: [{
                    time: {
                        unit: 'month'
                    },
                    gridLines: {
                        display: false
                    },
                    ticks: {
                        maxTicksLimit: 6
                    }
                }],
                yAxes: [{
                    ticks: {
                        min: 0,
                        max: 15000,
                        maxTicksLimit: 5
                    },
                    gridLines: {
                        display: true
                    }
                }],
            },
            legend: {
                display: false
            }
        }
    });
</script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
<script src="/js/demo/datatables-demo.js"></script>
<script>
    $("#carrito").change(function () {
        var selectedCart = $(this).children("option:selected").val();
        window.location.replace("/agregarArticulo/" + selectedCart.toString());
    });
</script>
<script>
    $("#art-carrito").change(function () {
        var selectedCart = $(this).children("option:selected").val();
        window.location.replace("/articulos/" + selectedCart.toString());
    });
</script>
<script type="text/javascript">
    $("#clientes").change(function () {
        var id = document.getElementById("clientes").value;
        window.location.href = "/ver-alquileres/" + id;
    });

</script>
</body>
</html>