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
                    /*enctype es para poder almacenar archivos*/
                    <form action="/crear-equipo/" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-marca">Marca</label>
                                <input id="marca" name="marca" type="text" class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-modelo">Modelo</label>
                                <input id="modelo" name="modelo" type="text" class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-descripcion-eq">Descripcion</label>
                                <input id="descripcion" name="descripcion" type="text"
                                       class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-costo">Costo Diario</label>
                                <input id="costo" name="costo" type="number"
                                       min="100.00" max="100000.00" step="50.00" value="100.00"
                                       class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-existencia">Existencia Inicial</label>
                                <input id="existencia" name="existencia" type="number"
                                       min="1" max="100" step="1" value="1"
                                       class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-imagen-eq">Imagen</label>
                                <input id="imagen" name="imagen" type="file" class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-3 col-md-4">
                                <label id="lb-familia">Familia de Equipos</label>
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
                                <button class="btn btn-primary" type="submit">Salvar</button>
                            </div>
                            <!-- Estado definido por el servicio -->
                            <!-- Fecha inicial definida por el servicio -->
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
                                <#if equipos?size != 0>
                                    <#list equipos as equipo>
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