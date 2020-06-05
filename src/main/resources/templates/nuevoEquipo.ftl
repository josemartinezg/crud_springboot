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
                    <form action="/crearArticuloAndItem/" method="post">
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
                                <input id="descripcion-eq" name="descripcion-eq" type="text" class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-existencia">Existencia Inicial</label>
                                <input id="existencia" name="existencia" type="number"
                                       min="1" max="100" step="1" value="1"
                                       class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-imagen-eq">Imagen</label>
                                <input id="imagen-eq" name="imagen-eq" type="image" class="form-control form-control-sm">
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
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Existencia</th>
                                <th>Costo Diario</th>
                            </tr>
                            </tfoot>
                            <tbody>
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