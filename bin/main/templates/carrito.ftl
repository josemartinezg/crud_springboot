<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">Carritos</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Carritos</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i> Elegir carrito</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-xl-3 col-md-6">
                            <label id="lbl-carrito">Carrito</label>
                            <select class ="form-control form-control-sm" id="carrito">
                                <option value="0">- Elija el Carrito -</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Agregar Nuevo Articulo</div>
                <div class="card-body">
                    <form action="/crearArticuloAndItem/" method="post">
                        <div class="row">
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-dpto">Departamento</label>
                                <select class ="form-control form-control-sm" id="dpto" name="dpto">
                                    <option value="0">- Elija el Departamento -</option>
                                </select>
                            </div>
                            <div class="col-xl-1 col-md-4">
                                <label id="lb-medida">Medida</label>
                                <select class ="form-control form-control-sm" id="medida" name="medida">
                                    <option value="0">- Elija la unidad de medida -</option>
                                </select>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <label id="lb-articulo">Artiuclo</label>
                                <input id="nombre-articulo" name="nombre-articulo" type="text" class="form-control form-control-sm">
                            </div>
                            <div class="col-xl-1 col-md-4">
                                <label id="lbl-cant">Cantidad</label>
                                <input id="cantidad" name="cantidad" type="number" min="0.5" max="50" step="0.25" value="1"
                                       class="custom-select custom-select-sm form-control form-control-sm">
                            </div>
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-precio">Precio</label>
                                <input id="precio" name="precio" type="number" min="0.00" max="5000" step="0.01" value="0"
                                       class="custom-select custom-select-sm form-control form-control-sm">
                            </div>
                            <label id="lbl-btn"></label>
                            <div class="col-xl-2 col-md-6 form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                <button class="btn btn-primary" type="submit">Salvar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                <div class="card mb-4">
                    <div class="card-header"><i class="fas fa-table mr-1"></i>DataTable Example</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Medida</th>
                                    <th>Departamento</th>
                                    <th>Articulo</th>
                                    <th>Cant.</th>
                                    <th>Precio</th>
                                    <th>Carrito</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Medida</th>
                                    <th>Departamento</th>
                                    <th>Articulo</th>
                                    <th>Cant.</th>
                                    <th>Precio</th>
                                    <th>Carrito</th>
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
                <div class="text-muted">Copyright &copy; Your Website 2019</div>
                <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                </div>
            </div>
        </div>
    </footer>
</div>