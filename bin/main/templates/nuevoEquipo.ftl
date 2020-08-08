<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Agregar Nuevo Equipo</div>
                <div class="card-body">
                    <form id="form" action="/crear-equipo/" method="post" enctype="multipart/form-data">
<#--                        Habilitando edición-->
                        <div class="row">
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-marca" for="marca">Marca</label>
                                <input id="marca" name="marca" type="text" class="form-control form-control-sm" required>
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-modelo" for="modelo">Modelo</label>
                                <input id="modelo" name="modelo" type="text" class="form-control form-control-sm" required>
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-descripcion-eq" for="descripcion">Descripcion</label>
                                <input id="descripcion" name="descripcion" type="text"
                                       class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-costo" for="costo">Costo Diario</label>
                                <input id="costo" name="costo" type="number"
                                       min="100.00" max="100000.00" step="50.00" value="100.00"
                                       class="form-control form-control-sm" required>
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-existencia" for="existencia">Existencia Inicial</label>
                                <input id="existencia" name="existencia" type="number"
                                       min="1" max="100" step="1" value="1"
                                       class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-imagen-eq" for="imagen">Imagen</label>
                                <input id="imagen" name="imagen" type="file" class="form-control-file form-control-sm">
                            </div>
                            <div class="col-xl-3 col-md-4">
                                <label id="lb-familia" for="familia">Familia de Equipos</label>
                                <select class ="form-control form-control-sm" id="familia" name="familia">
                                    <#list familias as fam>
                                        <option value="${fam.id}">
                                            ${fam.familiaEquipo.nombre} - ${fam.nombre}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <label id="lbl-btn"></label>
                            <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                <button class="btn btn-success" type="submit">Agregar</button>
                            </div>
                            <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                <a><button class="btn btn-dark" onclick="limpiarForm()">limpiar</button></a>
                            </div>
                            <!-- Estado definido por el servicio -->
                            <!-- Fecha inicial definida por el servicio -->
                        </div>
<#--                            TODO: Habilitando edición-->
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
                                <th>Imagen de Equipo</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Existencia</th>
                                <th>Costo Diario</th>
                                <th>Familia</th>
                                <th>Acciones</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Imagen de Equipo</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Existencia</th>
                                <th>Costo Diario</th>
                                <th>Familia</th>
                                <th>Acciones</th>
                            </tr>
                            </tfoot>
                            <tbody>
                                <#if equipos?size != 0>
                                    <#list equipos as equipo>
                                        <tr>
                                            <td>
                                                <img src="data:image/png;base64, ${equipo.imagenEquipo}"
                                                     height="80"
                                                     width="80">
                                            </td>
                                            <td>${equipo.marca}</td>
                                            <td><a href="../ver-equipo/${equipo.id}">${equipo.modelo}</a></td>
                                            <td>${equipo.descripcion}</td>
                                            <td>${equipo.cantidadEnExistencia}</td>
                                            <td>RD$${equipo.costoAlquilerDiario}</td>
                                            <td>${equipo.subFamiliaDeEquipos.familiaEquipo.nombre} -
                                            ${equipo.subFamiliaDeEquipos.nombre}</td>
                                            <td>
                                                <div class="row justify-content-center align-content-center">

                                                    <a href="/editar-equipo?id=${equipo.id}"><button class="btn btn-outline-warning">Editar</button></a>
                                                    <div>
                                                        <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#staticBackdrop">
                                                            Eliminar
                                                        </button>
                                                        <!-- Modal -->
                                                        <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h4 class="modal-title" id="staticBackdropLabel">Eliminar</h4>
                                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <strong>¿Esta seguro de eliminar el equipo <span class="badge badge-danger"> ${equipo.marca} ${equipo.modelo}</span>? Borraría toda la información relacionada.</strong>
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                                        <a href="/eliminar-equipo/${equipo.id}"><button class="btn btn-danger">Eliminar</button></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a href="/alquilar/${equipo.id}"> <button class="btn btn-outline-primary" type="submit">Agregar a Alquiler</button></a>
                                                </div>
                                            </td>
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