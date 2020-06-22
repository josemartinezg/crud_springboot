<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
        <div class="container-fluid">
            <#if clientes??>
                <div class="card-body">
                    <div class="col-xl-2 col-md-6">
                        <label id="lbl-cliente">Cliente</label>
                        <select class ="form-control form-control-sm" id="cliente" name="cliente">
                            <#list clientes as client>
                                <option value="${client.id}" >
                                    ${client.nombre} ${client.apellido}
                                </option>
                            </#list>
                        </select>
                    </div>
                    <label id="lbl-btn"></label>
                    <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                    <a href="/ver-alquileres-por-cliente/"><button class="btn btn-success" type="submit">Buscar</button></a>
                </div>
            </#if>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Equipos</div>
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Cliente</th>
                                <th>Fecha Renta</th>
                                <th>Fecha Entrega</th>
                                <th>Estado</th>
                                <th>Total</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>Cliente</th>
                                <th>Fecha Renta</th>
                                <th>Fecha Entrega</th>
                                <th>Estado</th>
                                <th>Total</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#if facturas??>
                                <#list facturas as factura>
                                    <tr>
                                        <td><a href="../realizar-alquiler/${factura.alquiler.cliente.id}">
                                                ${factura.alquiler.cliente.id}</a></td>
                                        <td>${factura.alquiler.cliente.nombre} ${factura.alquiler.cliente.apellido}</td>
                                        <td>${factura.alquiler.fechaDeAlquiler}</td>
                                        <td>${factura.alquiler.fechaDevolucionEsperada}</td>
                                        <td>${factura.alquiler.estado.nombre}</td>
                                        <td>RD$${factura.totalFacturado}</td>
                                    </tr>
                                </#list>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>