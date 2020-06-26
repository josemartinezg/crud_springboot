<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <#if error??>
                <div class="alert alert-error">No existe inventatio suficiente para realizar este alquiler.</div>
            </#if>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Agregar Nuevo Articulo</div>
                <div class="card-body">
                <#if alquiler??>
                    <form action="/agregar-equipo/${alquiler.id}" method="post">
                <#else>
                    <form action="/nuevo-alquiler" method="post">
                </#if>
                        <div class="row">
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-cliente">Cliente</label>
                                <select class ="form-control form-control-sm" id="cliente" name="cliente">
                                    <option value="0">- Seleccione un cliente-</option>
                                    <#list clientes as client>
                                        <option value="${client.id}" <#if cliente?? && alquiler??
                                        && alquiler.cliente.id == cliente.id>selected</#if>>
                                            ${client.nombre} ${client.apellido}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <!-- Estado definido por el servicio -->
                            <!-- Fecha inicial definida por el servicio -->
                            <div class="col-xl-2 col-md-5">
                                <label id="lb-fecha">Fecha de Devolucion</label>
                                <input id="fecha" name="fecha" type="date" class="form-control form-control-sm"
                                        <#if fechaDevolucion??> value="${fechaDevolucion}" </#if>>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <label id="lbl-equipos">Equipos</label>
                                <select class ="form-control form-control-sm" id="equipo" name="equipo">
                                    <#list equipos as equipo>
                                        <option value="${equipo.id}">
                                            ${equipo.marca} ${equipo.modelo}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-xl-1 col-md-3">
                                <label id="lbl-cantidad">Cantidad</label>
                                <input id="cantidad" name="cantidad" type="number"
                                       min="1" max="100" step="1" value="1"
                                       class="form-control form-control-sm">
                            </div>
                            <#if alquiler??>
                                <div class="col-xl-2 col-md-6">
                                    <label id="lbl-estado">Estado</label>
                                    <select class ="form-control form-control-sm" id="estado" name="estado">
                                        <#list estados as estado>
                                            <option value="${estado.id}" <#if estado?? && alquiler??
                                            && alquiler.estado.id == estado.id>selected</#if>>
                                                ${estado.nombre}
                                            </option>
                                        </#list>
                                    </select>
                                </div>
                            </#if>
                            <label id="lbl-btn"></label>
                            <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                <#if alquiler??>
                                    <a href="/agregar-equipo/${alquiler.id}"><button class="btn btn-warning" type="submit">Agregar Equipo</button></a>
                                <#else>
                                    <a href="/nuevo-alquiler"><button class="btn btn-primary" type="submit">Agregar Alquiler</button></a>
                                </#if>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <#if alquiler??>
                <div class="card-body">
                    <a href="/finalizar-alquiler/${alquiler.id}"><button class="btn btn-success" type="submit">Finalizar Alquiler</button></a>
                </div>
            </#if>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Alquileres</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Cant.</th>
                                <th>Costo Diario</th>
                                <th>Familia</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Cant.</th>
                                <th>Costo Diario</th>
                                <th>Familia</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#if nuevoAlquiler??>
                                <#if equiposEnAlquiler??>
                                    <#list equiposEnAlquiler as relacion>
                                        <tr>
                                            <td>${relacion.equipo.marca}</td>
                                            <td><a href="../ver-equipo/${relacion.equipo.id}">${relacion.equipo.modelo}</a></td>
                                            <td>${relacion.equipo.descripcion}</td>
                                            <td>${relacion.cantidad}</td>
                                            <td>RD$${relacion.equipo.costoAlquilerDiario}</td>
                                            <td>${relacion.equipo.subFamiliaDeEquipos.familiaEquipo.nombre} -
                                                ${relacion.equipo.subFamiliaDeEquipos.nombre}</td>
                                        </tr>
                                    </#list>
                                </#if>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid">
            <div class="d-flex align-items-center justify-content-between small">
                <div class="text-muted">${copyRight}</div>
                <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                </div>
            </div>
        </div>
    </footer>
</div>