<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Agregar Nuevo Articulo</div>
                <div class="card-body">
                    <form action="/agregar-equipo" method="post">
                        <div class="row">
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-cliente">Cliente</label>
                                <select class ="form-control form-control-sm" id="cliente" name="cliente">
                                    <option value="0">- Elija el Cliente -</option>
                                    <#list clientes as client>
                                        <option value="${client.id}">
                                            ${client.nombre} ${client.apellido}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-estado">Estado</label>
                                <select class ="form-control form-control-sm" id="estado" name="estado">
                                    <option value="0">- Elija un Estado -</option>
                                    <#list estados as estado>
                                        <option value="${estado.id}">
                                            ${estado.nombre}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <!-- Estado definido por el servicio -->
                            <!-- Fecha inicial definida por el servicio -->
                            <div class="col-xl-3 col-md-6">
                                <label id="lb-fecha">Fecha de Devolucion</label>
                                <input id="fecha" name="fecha" type="date" class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <label id="lbl-equipos">Equipos</label>
                                <select class ="form-control form-control-sm" id="equipo" name="equipo">
                                    <option value="0">- Elija un Equipo -</option>
                                    <#list equipos as equipo>
                                        <option value="${equipo.id}">
                                            ${equipo.marca} ${equipo.modelo}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-cantidad">Cantidad</label>
                                <input id="cantidad" name="cantidad" type="number"
                                       min="1" max="100" step="1" value="1"
                                       class="form-control form-control-sm">
                            </div>
                            <label id="lbl-btn"></label>
                            <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                <a href="/agregar-equipo"><button class="btn btn-warning" type="submit">Agregar</button></a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Equipos</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Existencia</th>
                                <th>Costo Diario</th>
                                <th>Familia</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Existencia</th>
                                <th>Costo Diario</th>
                                <th>Familia</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#if nuevoAlquiler != 1>
                                <#list equiposEnAlquiler as equipo>
                                    <tr>
                                        <td>${equipo.marca}</td>
                                        <td><a href="../ver-equipo/${equipo.id}">${equipo.modelo}</a></td>
                                        <td>${equipo.descripcion}</td>
                                        <td>${equipo.cantidadEnExistencia}</td>
                                        <td>RD$${equipo.costoAlquilerDiario}</td>
                                        <td>${equipo.subFamiliaDeEquipos.familiaEquipo.nombre} -
                                            ${equipo.subFamiliaDeEquipos.nombre}</td>
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