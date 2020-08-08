<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <#if clientes??>
                <div class="card mb-4">
                    <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Clientes</div>
                    <div class="card-body">
                        <div class="col-xl-2 col-md-6">
                            <label id="lbl-clientes">Cliente</label>
                            <select class ="form-control form-control-sm" id="clientes" name="clientes">
                                <#list clientes as client>
                                    <option value="${client.id}"<#if client.id == id>selected</#if> >
                                        ${client.nombre} ${client.apellido}
                                    </option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>
            </#if>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Alquileres</div>
                <div class="card-body">
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
            <div class="col-lg-10">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-chart-bar"></i>
                        Bar Chart Example</div>
                    <div class="card-body">
                        <canvas id="myBarChart" width="100%" height="50"></canvas>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>
            </div>
        </div>
    </main>
</div>

