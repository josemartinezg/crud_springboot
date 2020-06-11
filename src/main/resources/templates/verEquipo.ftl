<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Ver Equipo</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-xl-5 col-md-6">
                            <label id="lbl-imagen-eq">Imagen</label>
                            <img width="480" height="480" alt="star" src="data:image/gif;base64,${equipo.imagenEquipo}">
<#--                            <div class="col-lg-6 text-white showcase-img "></div>-->
                        </div>
                        <div class="col-xl-5 col-md-6">
                            <label id="lbl-marca">Marca</label>
                            <input id="marca" name="marca" value="${equipo.marca}" disabled>
                        </div>
                        <div class="col-xl-5 col-md-6">
                            <label id="lbl-modelo">Modelo</label>
                            <input id="modelo" name="modelo" value="${equipo.modelo}" disabled>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-5 col-md-6">
                            <label id="lbl-descripcion-eq">Descripcion</label>
                            <input id="descripcion" name="descripcion" value="${equipo.descripcion}" disabled>
                        </div>
                        <div class="col-xl-5 col-md-6">
                            <label id="lbl-costo">Costo Diario</label>
                            <input id="costo" name="costo" value="RD$${equipo.costoAlquilerDiario}" disabled>
                        </div>
                        <div class="col-xl-5 col-md-6">
                            <label id="lbl-existencia">Existencia</label>
                            <div id="existencia" name="existencia" value="${equipo.cantidadEnExistencia}" disabled>
                        </div>
                        <div class="col-xl-5 col-md-4">
                            <label id="lb-familia">Familia de Equipos</label>
                            <input id="familia" name="familia" value="${equipo.subFamiliaDeEquipos.familiaEquipo.nombre} |
                              ${equipo.subFamiliaDeEquipos.nombre}" disabled>
                        </div>
                        <label id="lbl-btnDelete"></label>
                        <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                            <a href="/eliminar-equipo/${equipo.id}"><button class="btn btn-danger">Eliminar</button></a>
                        </div>
                        <label id="lbl-btnEditar"></label>
                        <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                            <a href="/editar-equipo?id=${equipo.id}"><button class="btn btn-warning">Editar</button></a>
                        </div>
                        <label id="lbl-btnSave"></label>
                        <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                            <button class="btn btn-primary" type="submit">Agregar a Alquiler</button>
                        </div>

                        <!-- Estado definido por el servicio -->
                        <!-- Fecha inicial definida por el servicio -->
                    </input>
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