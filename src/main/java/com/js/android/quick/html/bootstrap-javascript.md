modal-fade
===
<div class="container">
    <button class="btn btn-primary" type="button">点击我</button>
    <div class="modal fade" id="mymodal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&time:</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">弹出效果展示</h4>
                </div>
                <div class="media-body">
                    <p>弹出框</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

modal-show
===

<div class="container">
    <button class="btn btn-primary" type="button">点击我</button>
    <div class="modal show" id="mymodal-show">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&time:</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">弹出效果展示</h4>
                </div>
                <div class="modal-body">
                    <p>弹出对话框</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

modal-lg
===

<div class="container">
    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#mymodal-lg">点击我大对话框</button>
    <div class="modal show" id="mymodal-lg">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&time:</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">大对话框</h4>
                </div>
                <div class="modal-body">
                    <p>弹出大对话框</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

modal-sm
===

<div class="container">
    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#mymodal-sm">点击我小对话框</button>
    <div class="modal show" id="mymodal-sm">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&time:</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">小对话框</h4>
                </div>
                <div class="modal-body">
                    <p>弹出小对话框</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

modal-button
===
<div class="container">
    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#mymodal-sm-button">按钮触发</button>
    <div class="modal fade" id="mymodal-sm-button">
      <div class="modal-dialog modal-sm">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">
                      <span aria-hidden="true">&times;</span>
                      <span class="sr-only">Close</span>
                  </button>
                  <h4 class="modal-title">按钮触发</h4>
              </div>

              <div class="modal-body">
                  <p>按钮触发对话框显示</p>
              </div>

              <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                  <button type="button" class="btn btn-primary">保存</button>
              </div>
          </div>
      </div>
    </div>
</div>

modal-link
===
<div class="container">
    <a class="btn btn-primary" href="#mymodal-sm-link">按钮触发</a>
    <div class="modal fade" id="mymodal-sm-link">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">按钮触发</h4>
                </div>

                <div class="modal-body">
                    <p>按钮触发对话框显示</p>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

modal-javascript
===
<div class="container">
    <button class="btn btn-primary" type="button" id="btnDialog">javascript触发</button>

    <div class="modal fade" id="mymodal-sm-backdrop">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">按钮触发</h4>
                </div>

                <div class="modal-body">
                    <p>按钮触发对话框显示</p>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
//    $(document).ready(function(){
//        $("#btnDialog").click(function(){
//            $("mymodal-sm-backdrop").modal();
//        });
//    });

    $(document).ready(function(){
        $("#btnDialog").click(function(){
            $("mymodal-sm-backdrop").modal({
                backdrop:"static"
            });
        });
    });
</script>


modal-toggle
===
div class="container">
<button class="btn btn-primary" type="button" id="btnToggle">javascript触发</button>

<div class="modal fade" id="mymodal-sm-toggle">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title">按钮触发</h4>
            </div>

            <div class="modal-body">
                <p>按钮触发对话框显示</p>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="btnClose">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
</div>

<script type="text/javascript">

    $(document).ready(function(){
        $("#btnToggle").click(function(){
            $("mymodal-sm-toggle").modal("toggle");
        });

        $("#btnClose").click(function(){
            $("mymodal-sm-toggle").modal("toggle");
        });
    });

</script>

dropdown-no-javascript
===
<div class="container">
    <div class="dropdown">
        <a href="javascript:void(0)" data-toggle="dropdown" class="btn btn-danger dropdown-toggle">下拉菜单 <b class="caret"></b></a>

        <ul class="dropdown-menu">
            <li role="presentation"><a href="###">CSS3</a></li>
            <li role="presentation"><a href="###">HTML5</a></li>
            <li role="presentation"><a href="###">Sass</a></li>
        </ul>
    </div>

</div>

dropdown-javascript
===
<div class="container">
    <button class="btn btn-primary" id="btnClick">触发按钮</button>
    <div class="dropdown">
        <a href="javascript:void(0)" data-toggle="dropdown" class="btn btn-danger dropdown-toggle" id="dropMenu">下拉菜单 <b class="caret"></b></a>

        <ul class="dropdown-menu">
            <li role="presentation"><a href="###">CSS3</a></li>
            <li role="presentation"><a href="###">HTML5</a></li>
            <li role="presentation"><a href="###">Sass</a></li>
        </ul>
    </div>
</div>

<script type="text/javascript">

    $(document).ready(function() {
        $("btnClick").click(function () {
            $("#dropMenu").dropdown();
        });
    });
</script>

scrollspy
===
<div class="container">
    <div id="navbar" class="navbar navbar-default">
        <a href="javascript:void(0)" class="navbar-brand">滚动监听</a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#Home">首页</a></li>
            <li ><a href="#Video">视频</a></li>
            <li ><a href="#Music">音乐</a></li>
            <li ><a href="#Map">地图</a></li>
        </ul>
    </div>
</div>

<div class="container scrollcontent" data-target="#navBar" data-spy="scroll">
    <h3 id="Home">首页</h3>

    <p>....</p>

    <h3 id="Music">音乐</h3>

    <p>....</p>

    <h3 id="Video">视频</h3>

    <p>....</p>

    <h3 id="Map">地图</h3>

    <p>....</p>
</div>


tab
===
<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#A" data-toggle="tab">公告</a></li>
        <li><a href="#B" data-toggle="tab">规则</a></li>
        <li><a href="#C" data-toggle="tab">论坛</a></li>
        <li><a href="#D" data-toggle="tab">安全</a></li>
        <li><a href="#E" data-toggle="tab">公益</a></li>
    </ul>
    <br/>
    <div class="tab-content">
        <div class="tab-pane active" id="A">公告的内容</div>
        <div class="tab-pane" id="B">规则的内容</div>
        <div class="tab-pane" id="C">论坛的内容</div>
        <div class="tab-pane" id="D">安全的内容</div>
        <div class="tab-pane" id="E">公益的内容</div>
    </div>
</div>

tab-javascript
===
<div class="container">
    <ul class="nav nav-tabs" id="tabNav">
        <li class="active"><a href="#A" data-toggle="tab">公告</a></li>
        <li><a href="#B" data-toggle="tab">规则</a></li>
        <li><a href="#C" data-toggle="tab">论坛</a></li>
        <li><a href="#D" data-toggle="tab">安全</a></li>
        <li><a href="#E" data-toggle="tab">公益</a></li>
    </ul>
    <br/>
    <div class="tab-content">
        <div class="tab-pane active" id="A">公告的内容</div>
        <div class="tab-pane" id="B">规则的内容</div>
        <div class="tab-pane" id="C">论坛的内容</div>
        <div class="tab-pane" id="D">安全的内容</div>
        <div class="tab-pane" id="E">公益的内容</div>
    </div>
</div>

<script>
    $("#tabNav a").click(function(){
        $(this).tab("show");
    });
</script>

tab-pills
===

<div class="container">
    <ul class="nav nav-pills" id="tabPills">
        <li class="active"><a href="#A" data-toggle="tab">公告</a></li>
        <li><a href="#B" data-toggle="tab">规则</a></li>
        <li><a href="#C" data-toggle="tab">论坛</a></li>
        <li><a href="#D" data-toggle="tab">安全</a></li>
        <li><a href="#E" data-toggle="tab">公益</a></li>
    </ul>
    <br/>
    <div class="tab-content">
        <div class="tab-pane active" id="A">公告的内容</div>
        <div class="tab-pane" id="B">规则的内容</div>
        <div class="tab-pane" id="C">论坛的内容</div>
        <div class="tab-pane" id="D">安全的内容</div>
        <div class="tab-pane" id="E">公益的内容</div>
    </div>
</div>

tab-fade
===
<div class="container">
    <ul class="nav nav-pills" id="tabNav">
        <li class="active"><a href="#A" data-toggle="tab">公告</a></li>
        <li><a href="#B" data-toggle="tab">规则</a></li>
        <li><a href="#C" data-toggle="tab">论坛</a></li>
        <li><a href="#D" data-toggle="tab">安全</a></li>
        <li><a href="#E" data-toggle="tab">公益</a></li>
    </ul>
    <br/>
    <div class="tab-content">
        <div class="tab-pane active fade in" id="A">公告的内容</div>
        <div class="tab-pane" id="B">规则的内容</div>
        <div class="tab-pane" id="C">论坛的内容</div>
        <div class="tab-pane" id="D">安全的内容</div>
        <div class="tab-pane" id="E">公益的内容</div>
    </div>
</div>

tip
===
<button class="btn btn-primary" data-original-title="top显示" data-toggle="tooltip" data-placement="top">Top显示</button>

<button class="btn btn-primary" data-original-title="right显示" data-toggle="tooltip" data-placement="right">Right显示</button>

<button class="btn btn-primary" data-original-title="left显示" data-toggle="tooltip" data-placement="left">Left显示</button>

<button class="btn btn-primary" data-original-title="bottom显示" data-toggle="tooltip" data-placement="bottom">Bottom显示</button>

tip-js
===
<div class="container">

    <button class="btn btn-primary" data-original-title="top显示" data-toggle="tooltip" data-placement="top">Top显示</button>

    <button class="btn btn-primary" data-original-title="right显示" data-toggle="tooltip" data-placement="right">Right显示</button>

    <button class="btn btn-primary" data-original-title="left显示" data-toggle="tooltip" data-placement="left">Left显示</button>

    <button class="btn btn-primary" data-original-title="bottom显示" data-toggle="tooltip" data-placement="bottom">Bottom显示</button>

</div>
<script>
    $('[data-toggle="tooltip"]').tooltip();

    $('[data-toggle="tooltip"]').tooltip({
        placement:"right",
        title:"使用参数方法"
    });
</script>

popover
===
<div class="container">
    <button id="btnPopover" class="btn btn-primary" data-original-title=""
            title="我要显示内容" data-content="bootstrap弹出的内容" data-toggle="popover" data-placement="right">
        right显示
    </button>
</div>

<script>
    $("[data-toggle='popover']").popover();
</script>

button-loading
===

<div class="container">
    <button id="btnLoading" class="btn btn-success" data-loading-text="正在加载...">确定</button>
</div>
<script>
    $(function(){
       $("#btnLoading").click(function(){
           $(this).button("loading");
       })
    });
</script>


radio-button
===
<div class="btn-group" data-toggle="buttons">
    <label class="btn btn-primary">
        <input type="radio" name="options"/>所有
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="options"/>删除
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="options"/>未删除
    </label>
</div>

checkbox-button
===
<div class="btn-group" data-toggle="buttons">
    <label class="btn btn-primary">
        <input type="checkbox" name="options"/>Java
    </label>
    <label class="btn btn-primary">
        <input type="checkbox" name="options"/>C++
    </label>
    <label class="btn btn-primary">
        <input type="checkbox" name="options"/>Object C
    </label>
</div>

button-toggle
===
<div class="container">
    <button id="btnLoad" class="btn btn-primary active"
            data-toggle="button" data-complete-text="加载完成" data-loading-text="正在加载....">按钮</button>
</div>

<script>
    $(function(){
        $("#btnLoad").button("toggle");
    });
</script>

button-complete
===
<div class="container">
    <button id="btnLoad" class="btn btn-primary active"
            data-toggle="button" data-complete-text="加载完成" data-loading-text="正在加载....">按钮</button>
</div>

<script>
    $(function(){
        $("#btnLoad").button("loading");
        setTimeout(function(){
            $("#btnLoad").button("reset");
        });

        $("#btnLoad").button("complete");
    });
</script>

collapse
===

<div class="panel-group" id="panelContainer">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse1" data-toggle="collapse" data-parent="#panelContainer">标题一</a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse in">
            <div class="panel-body">
                标题一对应的内容
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse2" data-toggle="collapse" data-parent="#panelContainer">标题二</a>
            </h4>
        </div>
        <div id="collapse2" class="panel-collapse collapse in">
            <div class="panel-body">
                标题二对应的内容
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse3" data-toggle="collapse" data-parent="#panelContainer">标题三</a>
            </h4>
        </div>
        <div id="collapse3" class="panel-collapse collapse in">
            <div class="panel-body">
                标题三对应的内容
            </div>
        </div>
    </div>

</div>

collapse-one
===
<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#myCol">点击</button>
<div id="myCol" class="collapse in">内容</div>


accordion
===
<div class="panel-group" id="panelContainer">
    <div class="panel panel-default panel-accordion">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse1" data-toggle="collapse" data-parent="#panelContainer">标题一</a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse in">
            <div class="panel-body">
                标题一对应的内容
            </div>
        </div>
    </div>

    <div class="panel panel-default panel-accordion">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse2" data-toggle="collapse" data-parent="#panelContainer">标题二</a>
            </h4>
        </div>
        <div id="collapse2" class="panel-collapse collapse in">
            <div class="panel-body">
                标题二对应的内容
            </div>
        </div>
    </div>

    <div class="panel panel-default panel-accordion">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse3" data-toggle="collapse" data-parent="#panelContainer">标题三</a>
            </h4>
        </div>
        <div id="collapse3" class="panel-collapse collapse in">
            <div class="panel-body">
                标题三对应的内容
            </div>
        </div>
    </div>

</div>

collapse-js
===

<div class="panel-group" id="panelContainer">
    <div class="panel panel-default panel-accordion">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse1" data-toggle="collapse" data-parent="#panelContainer">标题一</a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse in">
            <div class="panel-body">
                标题一对应的内容
            </div>
        </div>
    </div>

    <div class="panel panel-default panel-accordion">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse2" data-toggle="collapse" data-parent="#panelContainer">标题二</a>
            </h4>
        </div>
        <div id="collapse2" class="panel-collapse collapse in">
            <div class="panel-body">
                标题二对应的内容
            </div>
        </div>
    </div>

    <div class="panel panel-default panel-accordion">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a href="#collapse3" data-toggle="collapse" data-parent="#panelContainer">标题三</a>
            </h4>
        </div>
        <div id="collapse3" class="panel-collapse collapse in">
            <div class="panel-body">
                标题三对应的内容
            </div>
        </div>
    </div>

</div>
<script>
    //单独，不影响
    $().collapse({"parent":false});
</script>

carousel
===
<div id="carouselcontainer" class="carousel" data-ride="carousel" style="width: 50%;height: 450px;">
    <ol class="carousel-indicators">
        <li class="active">1</li>
        <li>2</li>
        <li>3</li>
        <li>4</li>
    </ol>

    <div class="carousel-inner" style="width: 100%;height: 430px;">
        <div class="item active">
            <a href="#"><img src="1.jpg" alt=""/></a>
            <div class="carousel-caption">
                <h3>一朵漂亮的花</h3>
                <p>非常漂亮的玫瑰花</p>
            </div>
        </div>
        <div class="item">
            <a href="##"><img src="2.jpg" alt=""/></a>
        </div>
        <div class="item">
            <a href="##"><img src="3.jpg" alt=""/></a>
        </div>
        <div class="item">
            <a href="##"><img src="4.jpg" alt=""/></a>
        </div>
    </div>

    <a href="#" class="left carousel-control">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>

    <a href="#" class="left carousel-control">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>

carousel-js
===

<div id="carouselcontainer" class="carousel" data-ride="carousel" style="width: 50%;height: 450px;">
    <ol class="carousel-indicators">
        <li class="active">1</li>
        <li>2</li>
        <li>3</li>
        <li>4</li>
    </ol>

    <div class="carousel-inner" style="width: 100%;height: 430px;">
        <div class="item active">
            <a href="#"><img src="1.jpg" alt=""/></a>
            <div class="carousel-caption">
                <h3>一朵漂亮的花</h3>
                <p>非常漂亮的玫瑰花</p>
            </div>
        </div>
        <div class="item">
            <a href="##"><img src="2.jpg" alt=""/></a>
        </div>
        <div class="item">
            <a href="##"><img src="3.jpg" alt=""/></a>
        </div>
        <div class="item">
            <a href="##"><img src="4.jpg" alt=""/></a>
        </div>
    </div>

    <a href="#" class="left carousel-control">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>

    <a href="#" class="left carousel-control">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>

<script>
    $("#carouselcontainer").carousel({
        wrap:false
    });

    $("#carouselcontainer a.left").click(function(){
        $("#carouselcontainer").carousel("prev");
    });

    $("#carouselcontainer a.right").click(function(){
        $("#carouselcontainer").carousel("next");
    });

</script>

affix
===
<body data-spy="scroll" data-target="#Scrollspy">
    <div class="container">
        <div class="row">
            <div class="col-xs-3">
                <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="200">
                    <li class="active"><a href="#section">起步</a></li>
                    <li><a href="#secion2">CSS</a></li>
                    <li><a href="#secion3">组件</a></li>
                    <li><a href="#secion4">插件</a></li>
                    <li><a href="#section5">定制</a></li>
                </ul>
            </div>
            <div class="col-xs-9">
                <h2 id="section1">第一部分</h2>
                <p>.....</p>
                <hr/>

                <h2 id="section2">第二部分</h2>
                <p>.....</p>
                <hr/>

                <h2 id="section3">第三部分</h2>
                <p>.....</p>
                <hr/>

                <h2 id="section4">第四部分</h2>
                <p>.....</p>
                <hr/>

                <h2 id="section5">第五部分</h2>
                <p>.....</p>
                <hr/>

                <h2 id="section6">第六部分</h2>
                <p>.....</p>
                <hr/>
            </div>
        </div>
    </div>
</body>





























