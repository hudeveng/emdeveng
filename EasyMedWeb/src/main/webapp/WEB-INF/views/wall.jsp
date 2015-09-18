<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pridet Technologies</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<%=request.getContextPath()%>/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=request.getContextPath()%>/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/dist/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Pridet Technologies</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-laptop"></i> The Wall</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-inbox"></i> My Inbox</span></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-cubes"></i> My Inventory</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart"></i> My Reports</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-filter"></i> My Filters<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Filter1</a>
                                </li>
                                <li>
                                    <a href="#">Filter2</a>
                                </li>
                                <li>
                                    <a href="#">Filter3</a>
                                </li>
                                <li>
                                    <a href="#">Filter4</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <!-- Modals for Action-->
        <!-- Modal for Reassign-->
        <div class="modal fade" id="myModal-reassign" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Reassign to Store:</h4>
              </div>
              <div class="modal-body">
                <p>Select a Particular store to reassign to</p>
                <select class="store-list">
                    <option>Select</option>
                    <option>Store 1</option>
                    <option>Store 2</option>
                </select>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-primary">Reassign</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
        <!-- Modal for Reassign-->
        <div class="modal fade" id="myModal-cancel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Cancel the Order</h4>
              </div>
              <div class="modal-body">
                <p>Reason for Cancel</p>
                <select class="cancel-reason">
                    <option>Select</option>
                    <option>Cancel Reason 1</option>
                    <option>Cancel Reason 1</option>
                </select>
                <p>Comments: <textarea class="form-control" rows="5" ></textarea></p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-primary">Cancel Order</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">The Wall</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            The Wall consists of all the requests
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="nosort">Order Id</th>
                                            <th>Recieved</th>
                                            <th>Due</th>
                                            <th>Activity</th>
                                            <th>Status</th>
                                            <th>Location</th>
                                            <th>Assignee</th>
                                            <th>Priority</th>
                                            <th>Action</th>
                                            <th>Details</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Process</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td><i class="fa fa-angle-double-up"></i></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Shipped</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td><i class="fa fa-angle-double-up"></i></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Delivered</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td><i class="fa fa-angle-double-up"></i></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Process</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td><i class="fa fa-angle-double-up"></i></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Shipped</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Delivered</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td><i class="fa fa-angle-double-up"></i></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td><i class="fa fa-angle-double-up"></i></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td><i class="fa fa-angle-double-up"></i></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                        <tr class="">
                                            <td>110011</td>
                                            <td>10:00 27Aug15</td>
                                            <td>10:00 27Aug15</td>
                                            <td>PB</td>
                                            <td>Open</td>
                                            <td>Location</td>
                                            <td>None</td>
                                            <td></td>
                                            <td>
                                                <select class="selectpicker">
                                                    <option>Select</option>
                                                    <option value="reassign" data-toggle="modal" data-target="#myModal-reassign">Reassign</option>
                                                    <option value="cancel" data-toggle="modal" data-target="#myModal-cancel">Cancel</option>
                                                </select>
                                            </td>
                                            <td><a href="order.html"  onclick="window.open('order.html', 'newwindow', 'width=700, height=650'); return false;"> <button type="button" class="btn btn-primary">Details</button></a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%=request.getContextPath()%>/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true,
                'aoColumnDefs': [{
           'bSortable': false,
           'aTargets': 'nosort'
        }]
        });
    });
    </script>
    <script>
    $(".selectpicker").change(function () {
        if ($(this).val() == "reassign") {
             $('#myModal-reassign').modal('show') 
        }
        if ($(this).val() == "cancel") {
             $('#myModal-cancel').modal('show') 
        }
    });
    </script>

</body>

</html>
