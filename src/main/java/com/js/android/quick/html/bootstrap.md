table
===
<table clas="table">
    <thead>
    <tr>
        <th>标题1</th>
        <th>标题2</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>内容1</td>
        <td>内容2</td>
    </tr>
    </tbody>
</table>

table-stripped
===
<table clas="table table-stripped">
    <thead>
    <tr>
        <th>标题1</th>
        <th>标题2</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>内容1</td>
        <td>内容2</td>
    </tr>
    </tbody>
</table>

img
===
<div class="row">
        <div class="col-sm-4">
            <img src="1.jpg" alt=""/>
            <div>默认图片</div>
        </div>
        <div class="col-sm-4">
            <img class="img-circle" src="1.jpg" alt=""/>
            <div>圆形图片</div>
        </div>
        <div class="col-sm-4">
            <img class="img-rounded" src="1.jpg" alt=""/>
            <div>圆角图片</div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <img src="1.jpg" alt="" class="img-thumbnail"/>
                <div>缩略图</div>
            </div>
            <div class="col-sm-6">
                <img src="1.jpg" alt="" class="img-responsive" style="width: 40px;height: 40px;"/>
                <div>响应式图片</div>
            </div>
        </div>
    </div>

one-img
===
 <img class="img-rounded" src="1.jpg" alt=""/>
 <div>圆角图片</div>

glyphicon
===
<span class="glyphicon glyphicon-search"></span>
    <span class="glyphicon glyphicon-star"></span>
    <span class="glyphicon glyphicon-music"></span>

input-group
===
<div class="input-group">
        <input type="text" class="form-control" placeholder="用户名"/>
        <span class="input-group-addon" id="basic-addon2">@gmail.com</span>
    </div>
    <br/><br/>
    <div class="input-group">
        <span class="input-group-addon">$</span>
        <input type="text" class="form-control"/>
        <span class="input-group-addon">.00</span>
    </div>

input-group-size
===
<div class="input-group input-group-lg">
        <input type="text" class="form-control" placeholder="用户名"/>
        <span class="input-groupon-addon">@gmail.com</span>
    </div>
    <div class="input-group">
        <input type="text" class="form-control" placeholder="用户名"/>
        <span class="input-group-addon">@gmail.com</span>
    </div>
    <div class="input-group input-group-sm">
        <input type="text" class="form-control" placeholder="用户名"/>
        <span class="input-group-addon">@gmail.com</span>
    </div>

input-group-checkbox
===
<div class="input-group">
        <span class="input-group-addon"> <input type="checkbox"/> </span>
        <input type="text" class="form-control" placeholder="用户名"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon"><input type="radio"/></span>
        <input type="text" class="form-control" placeholder="用户名"/>
    </div>

input-group-btn
===
<div class="input-group">
        <input type="text" class="form-control" placeholder="用户名"/>
        <span class="input-group-btn">
            <button class="btn btn-primary" type="button">搜索</button>
        </span>
    </div>

input-group-menu
===
<div class="input-group">
        <div class="input-group-btn">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">请选择 <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">宝贝</a></li>
                <li><a href="#">店铺</a></li>
            </ul>
        </div>
        <input type="text" class="form-control" placeholder="请输入关键字"/>
        <span class="input-group-btn">
            <button class="btn btn-primary" type="button">搜索</button>
        </span>
    </div>

input-group-menu-dropdown
===
<div class="input-group">
        <div class="input-group-btn">
            <button class="btn btn-default">请选择</button>
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">宝贝</a></li>
                <li><a href="#">店铺</a></li>
            </ul>
            <input type="text" class="form-control" placeholder="输入关键字"/>
            <span class="input-group-btn">
                <button class="btn btn-primary" type="button">搜索</button>
            </span>
        </div>
    </div>


dropdown
===
<div class="dropdown">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">下拉菜单
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="#">Javascript</a></li>
        <li><a href="#">CSS3</a></li>
        <li><a href="#">HTML5</a></li>
        <li><a href="#">jQuery</a></li>
    </ul>
</div>

dropdown-separator
===
<div class="dropdown">
        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
            下拉菜单
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="#">CSS3</a></li>
            <li><a href="#">HTML5</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">标题2</li>
            <li><a href="#">Javascript</a></li>
            <li><a href="#">jQuery</a></li>
        </ul>
    </div>

dropdown-status
===
<div class="row">
        <div class="col-lg-3 text-right">
            <div class="dropdown">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu pull-right">
                    <li class="dropdown-header"><a href="#">标题1</a></li>
                    <li class="active"><a href="#">CSS#</a></li>
                    <li class="disabled"><a href="#">Javascript</a></li>
                </ul>
            </div>
        </div>
    </div>

btn-group
===
<div class="btn-group">
        <button type="button" class="btn btn-primary">左</button>
        <button type="button" class="btn btn-primary">中</button>
        <button type="button" class="btn btn-primary">右</button>
    </div>

btn-group-glyphicon
===
<div class="btn-group">
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-left"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-center"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-right"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
    </div>

btn-group-toolbar
===
<div class="btn-group">
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-left"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-center"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-right"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
    </div>
    <div class="btn-group">
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-font"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-bold"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-italic"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
    </div>

btn-group-size
===
<div class="btn-group btn-group-lg">
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-left"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-center"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-right"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
    </div>
    <div class="btn-group">
        <div class="btn-group">
            <button class="btn btn-default">
                <span class="glyphicon glyphicon-font"></span>
            </button>
            <button class="btn btn-default">
                <span class="glyphicon glyphicon-bold"></span>
            </button>
            <button class="btn btn-default">
                <span class="glyphicon glyphicon-italic"></span>
            </button>
        </div>
    </div>
    <div class="btn-group btn-group-sm">
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-left"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-center"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-right"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
    </div>
    <div class="btn-group btn-group-xs">
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-left"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-center"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-right"></span>
        </button>
        <button class="btn btn-default">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
    </div>

btn-group-contain
===
<div class="btn-group">
        <button class="btn btn-default" type="button">
            我的淘宝
        </button>
        <button class="btn btn-default" type="button">
            购物车
        </button>
        <div class="btn-group">
            <button class="btn btn-default">
                收藏夹
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="">收藏的宝贝</a></li>
                <li><a href="">收藏的店铺</a></li>
            </ul>
        </div>
        <button class="btn btn-default" type="button">商品分类</button>
        <button class="btn btn-default" type="button">卖家中心</button>
    </div>

btn-group-vertical
===
<div class="btn-group-vertical">
        <button class="btn btn-default" type="button">我的淘宝</button>
        <button class="btn btn-default" type="button">购物车</button>
        <div class="btn-group">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" type="button">收藏夹
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">收藏的宝贝</a></li>
                <li><a href="#">收藏的店铺</a></li>
            </ul>
        </div>
        <button class="btn btn-default" type="button">商品分类</button>
        <button class="btn btn-default" type="button">卖家分类</button>
    </div>

btn-group-justfied
===
<div class="btn-group btn-group-justified">
    <a href="#" class="btn btn-default">我的淘宝</a>
    <a href="#" class="btn btn-default">购物车</a>
    <a href="#" class="btn btn-default">商品分类</a>
    <a href="#" class="btn btn-default">卖家中心</a>
</div>



btn-group-menu
===
<div class="btn-group">
        <div class="btn-group">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" type="button">
                收藏夹
                <span class="caret"></span>
            </button>
            <ul>
                <li><a href="#">收藏的宝贝</a></li>
                <li><a href="#">收藏的店铺</a></li>
            </ul>
        </div>
    </div>

btn-group-dropup
===
<div class="btn-group dropup">
        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" type="button">
            收藏夹
            <span class="caret"></span>
        </button>
        <ul>
            <li><a href="">收藏的宝贝</a></li>
            <li>   <a href="">收藏的店铺</a></li>
        </ul>
    </div>

btn-group-primary
===
<div class="btn-group dropup">
        <div class="btn-group">
            <button class="btn btn-primary btn-sm">收藏夹</button>
            <button class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown" type="button">
                <span class="caret"></span>
            </button>
            <ul class="dropdown">
                <li><a href="">收藏的宝贝</a></li>
                <li><a href="">收藏的店铺</a></li>
            </ul>
        </div>
    </div>

row-col
===
<div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">第一行lg-4</div>
        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">第二行lg-8</div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">第一行lg-4</div>
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">第二行lg-4</div>
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">第三行lg-4</div>
    </div>
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">第一行lg-4</div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">第二行lg-4</div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">第三行lg-4</div>
    </div>


row-col-merge-one
===
<div class="row">
                  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">第一行lg-12</div>
              </div>


row-col-merge-one-container
===
<div class="row">
                  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 20px 20px 20px 20px;border: 1px solid #0000ff;">第一行lg-12</div>
              </div>



row-col-split-2
===
<div class="row">
        <div class="col-lg-${col1} col-md-${col1} col-sm-${col1} col-xs-${col1}">第一行lg-${col1}</div>
        <div class="col-lg-${col2} col-md-${col2} col-sm-${col2} col-xs-${col2}">第二行lg-${col2}</div>
    </div>

row-col-split-3
===
<div class="row">
        <div class="col-lg-${col1} col-md-${col1} col-sm-${col1} col-xs-${col1}">第一行lg-${col1}</div>
        <div class="col-lg-${col2} col-md-${col2} col-sm-${col2} col-xs-${col2}">第二行lg-${col2}</div>
        <div class="col-lg-${col3} col-md-${col3} col-sm-${col3} col-xs-${col3}">第二行lg-${col3}</div>
    </div>

row-col-full
===
<div class="container-full">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">第一行lg-4</div>
        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">第二行lg-8</div>
    </div>
</div>

row-col-offset
===
<div class="row">
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">第一行col-md-2</div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">第一行col-md-2</div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">第一行col-md-2</div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">第一行col-md-2</div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">第一行col-md-2</div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">第一行col-md-2</div>
    </div>
    <div class="row">
        <div class="col-md-2 col-md-offset-2">第二行(1)col-md-2</div>
        <div class="col-md-2">第二行(2)col-md-2</div>
        <div class="col-md-2">第二行(3)col-md-2</div>
        <div class="col-md-2 col-md-offset-1">第二行(4)col-md-2</div>
        <div class="col-md-2">第二行col-md-2(5)</div>
    </div>

row-push-pull
===
<div class="row">
        <div class="col-xs-2">(1)xs-2</div>
        <div class="col-xs-2">(2)xs-2</div>
        <div class="col-xs-2">(3)xs-2</div>
        <div class="col-xs-2">(4)xs-2</div>
        <div class="col-xs-2">(4)xs-2</div>
        <div class="col-xs-2">(4)xs-2</div>
    </div>
    <div class="row">
        <div class="col-xs-2 col-xs-pull-2">(1)xs-2</div>
        <div class="col-xs-2">(2)xs-2</div>
        <div class="col-xs-2">(3)xs-2</div>
        <div class="col-xs-2">(4)xs-2</div>
        <div class="col-xs-2">(5)xs-2</div>
        <div class="col-xs-2">(6)xs-2</div>
    </div>
    <div class="row">
        <div class="col-xs-2 col-xs-push-2">(1)xs-2</div>
        <div class="col-xs-2">(2)xs-2</div>
        <div class="col-xs-2">(3)xs-2</div>
        <div class="col-xs-2">(4)xs-2</div>
        <div class="col-xs-2">(5)xs-2</div>
        <div class="col-xs-2">(6)xs-2</div>
    </div>
    <div class="row">
        <div class="col-xs-2 col-xs-push-2">(1)xs-2</div>
        <div class="col-xs-2 col-xs-pull-2">(2)xs-2</div>
        <div class="col-xs-2">(3)xs-2</div>
        <div class="col-xs-2">(4)xs-2</div>
        <div class="col-xs-2">(5)xs-2</div>
        <div class="col-xs-2">(6)xs-2</div>
    </div>


row-col-nest
===
.rowfirst{height:50px;}
.nestedrow{
    background-color:#cfc7c8;border:1px solid #0000ff;height:25px;
}

    <div class="row">
        <div class="col-md-6 rowfirst">
            <div class="row">
                <div class="col-md-6 nestedrow">内嵌一列</div>
                <div class="col-md-6 nestedrow">内嵌二列</div>
            </div>
        </div>
        <div class="col-md-6">
            第二行.col-md-6
        </div>
    </div>


container
===
<div class="container">
</div>

list-item-div
===
<div class="row">
    <div class="col-lg-12">
        <div class="list-item-div" style="background: #dddddd;border-top: 2px solid #0000ff;">
                        <div class="list-item-span10-1 text-center">
                            <span class="label label-info"> 名称</span>
                        </div>
                        <div class="list-item-span10-1">
                            <span class="label label-primary">可用</span>
                        </div>
                        <div class="list-item-span10-4">
                            <span class="label label-primary">冻结</span>
                        </div>
                        <div  class="list-item-span10-1">
                            <span  class="btn-sm btn-warning">总量</span>
                        </div>
                        <div class="list-item-span10-1">
                            <span  class="btn-sm btn-info">估值(CNY)</span>
                        </div>
                        <div class="list-item-span10-1">
                            <span class="btn-sm btn-primary">操作</span>
                        </div>
                        <div class="list-item-span10-1">
                            交易
                        </div>
                    </div>
                    <!-- 在此for循环 -->
                    <div class="list-item-div">
                        <div class="list-item-span10-1 text-center">
                            <span class="label label-info">名称</span>
                        </div>
                        <div class="list-item-span10-1">
                            <span class="label label-primary"> 可用</span>
                        </div>
                        <div class="list-item-span10-4">
                            <a href="/ub/blog?blogID=${blog.blogID}">冻结</a>
                        </div>
                        <div  class="list-item-span10-1">
                            <a href="/ub/blogeditv?blogID=${blog.blogID}&categoryID=${blog.categoryID}" class="btn-sm btn-warning">总量</a>
                        </div>
                        <div class="list-item-span10-1">
                            <a href="/ub/blog?categoryID=${blog.categoryID}&blogID=${blog.blogID}" class="btn-sm btn-info">估值</a>
                        </div>
                        <div class="list-item-span10-1">
                            <a href="/ub/blogaddv?categoryID=${blog.categoryID}" class="btn-sm btn-primary">估值(CNY)</a>
                        </div>
                        <div class="list-item-span10-1">
                            ###${blog.categoryname}
                            <a href="/ub/blogaddv?categoryID=${blog.categoryID}" class="btn-sm btn-primary">去交易</a>
                        </div>
                    </div>
                 </div>
              </div>
hr
===
<!-- 创建一条分隔线 -->
<hr style="background: #999999;margin: 5px 0 5px 0;">














































