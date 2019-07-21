button-glyphicon
===
<p>
    <button type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-sort-by-attributes"></span>
    </button>
    <button type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-sort-by-attributes-alt"></span>
    </button>
    <button type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-sort-by-order"></span>
    </button>
    <button type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-sort-by-order-alt"></span>
    </button>
</p>
<button type="button" class="btn btn-default btn-lg">
    <span class="glyphicon glyphicon-user"></span> User
</button>
<button type="button" class="btn btn-default btn-sm">
    <span class="glyphicon glyphicon-user"></span> User
</button>
<button type="button" class="btn btn-default btn-xs">
    <span class="glyphicon glyphicon-user"></span> User
</button>

form-inline
===
<div class="container form-inline">
    <div class="form-group">
        <label for="txtUserName">用户名</label>
        <input type="text" class="form-control" id="txtUserName" placeholder="请输入用户名">
    </div>

    <div class="form-group">
        <label for="txtPassWord">密码</label>
        <input type="password" class="form-control" id="txtPassWord" placeholder="请输入密码">
    </div>
     <div class="form-group">
                <label for=""></label>
                    <button type="submit" class="btn btn-primary">提交</button>
            </div>
</div>

form-horizontal
===
<div class="form-horizontal">
    <div class="form-group">
        <label for="txtUserName1" class="control-label col-lg-1">用户名</label>
        <div class="col-lg-3">
            <input type="text" id="txtUserName1" class="form-control" placeholder="请输入用户名"/>
        </div>
    </div>
    <div class="form-group">
        <label for="" class="control-label col-lg-1">密码</label>
        <div class="col-lg-3">
            <input type="text" id="password" class="form-control" placeholder="请输入密码"/>
        </div>
    </div>
     <div class="form-group">
            <label for="" class="control-label col-lg-1"></label>
            <div class="col-lg-3">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>
</div>

form-horizontal-better
===
<form action="/" method="post">
<div class="form-horizontal">
    <div class="form-group">
        <label for="txtUserName1" class="control-label col-lg-1">用户名</label>
        <div class="col-lg-3">
            <input type="text" class="form-control" placeholder=""/>
        </div>
    </div>
    <div class="form-group">
        <label for="" class="control-label col-lg-1">密码</label>
        <div class="col-lg-3">
            <input type="text" class="form-control" placeholder=""/>
        </div>
    </div>
     <div class="form-group">
            <label for="" class="control-label col-lg-1"></label>
            <div class="col-lg-3">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>
</div>
</form>

form-horizontal-withsubmit
===
<div class="form-horizontal">
            <div class="form-group">
                <label for="txtUserName1" class="control-label col-lg-3">请选择充值账户</label>
                <div class="col-lg-9">
                    <!--<input type="text" id="txtUserName1" class="form-control" placeholder="请输入用户名"/>-->
                    <select name="" id="" class="form-control">--请选择充值账户---
                        <option value="">--请选择充值账户---</option>
                        <option value="">工商银行</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="" class="control-label col-lg-3">填写充值金额</label>
                <div class="col-lg-9">
                    <input type="text" id="password" class="form-control" placeholder="填写充值金额"/>
                </div>
            </div>
            <div class="form-group">
                <label for="" class="control-label col-lg-3">填写充值金额</label>
                <div class="col-lg-9">
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </div>
        </div>


form-row
===
<div class="row">
        <label for="" class="control-label col-lg-1">用户名</label>
        <div class="col-lg-3">
            <input type="text" class="form-control"/>
        </div>
    </div>

    <div class="row">
        <label for="" class="control-label col-lg-1">密码</label>
        <div class="col-lg-3">
            <input type="text" class="form-control"/>
        </div>
    </div>


form-select
===
<div class="form-horizontal">
    <div class="form-group">
        <label for="" class="control-label col-lg-1">Select</label>
        <div class="col-lg-3">
            <select name="" class="form-control">
                <option value="">Javascript</option>
                <option value="">Html</option>
                <option value="">Css</option>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label for="" class="control-label col-lg-1">Selected</label>
        <div class="col-lg-3">
            <select name="" class="form-control" multiple="multiple">
                <option value="">Javascript</option>
                <option value="">Html</option>
                <option value="">Css</option>
            </select>
        </div>
    </div>
</div>

form-textarea
===
<div class="form-horizontal">
    <div class="form-group">
        <label for="" class="control-label col-lg-1">textarea</label>
        <div class="col-lg-3">
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
    </div>
</div>
form-radio
===
<div class="radio">
    <label for="">
        <input type="radio"/>男&nbsp;
        <input type="radio"/>女
    </label>
</div>
form-checkbox
===
<div class="checkbox">
    <label for="">
        <input type="checkbox" value=""/>HTML
        <input type="checkbox" value=""/>CSS
        <input type="checkbox" value=""/>Javascript
    </label>
</div>
form-checkbox-inline
===
<label for="" class="checkbox-inline">
    <input type="checkbox"/>HTML
</label>
<label for="" class="checkbox-inline">
    <input type="checkbox"/>CSS
</label>
<label for="" class="checkbox-inline">
    <input type="checkbox"/>Javascript
</label>
form-focus
===
<div class="form-horizontal">
    <div class="form-group">
        <label for="" class="control-label col-lg-1">用户名</label>
        <div class="col-lg-3">
            <input type="text" class="form-control" placeholder="请输入用户名" value=""/>
        </div>
    </div>
    <div class="form-group">
        <label for="" class="control-label col-lg-1"></label>
        <div class="col-lg-3">
            <input type="text" class="form-control" place="输入密码" value=""/>
        </div>
    </div>
</div>

form-disabled
===
<div class="form-group">
    <label for="" class="control-label col-lg-1">用户名</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" disabled="disabled"/>
    </div>
</div>

<div class="form-group">
    <label for="" class="control-label col-lg-1">密码</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" disabled="disabled"/>
    </div>
</div>
form-fieldset-disabled
===
<fieldset disabled="disabled">
    <legend></legend>
    <div class="form-group">
        <label for="" class="col-lg-1">用户名</label>
        <div class="col-lg-3">
            <input type="text" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="" data-color="col-lg-1">密码</label>
        <div class="col-lg-3">
            <input type="password" class="form-control" placeholder="密码" value=""/>
        </div>
    </div>
</fieldset>

form-has-warning
===
<div class="form-horizontal">
    <div class="form-group has-warning">
        <label for="" class="control-label col-lg-1">has-warning</label>
        <div class="col-lg-3">
            <input type="text" class="form-control" value="" placeholder="has-warning"/>
        </div>
    </div>

    <div class="form-group has-error">
        <label for="" class="control-label col-lg-1">has-error</label>
        <div class="col-lg-3">
            <input type="text" class="form-control" value="" placeholder="has-error"/>
        </div>
    </div>

    <div class="form-group has-success">
        <label for="" class="control-label col-lg-1">has-success</label>
        <div class="col-lg-3">
            <input type="text" class="form-control" value="" placeholder="has-success"/>
        </div>
    </div>
</div>

form-feedback-warning
===
<div class="form-group has-warning has-feedback">
    <label for="" class="control-label col-lg-1">has warning</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" placeholder="has-warning" value=""/>
        <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
    </div>
</div>
form-feedback-error
===
<div class="form-group has-error has-feedback">
    <label for="" class="control-label col-lg-1">has warning</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" placeholder="has-warning" value=""/>
        <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
    </div>
</div>

form-feedback-success
===
<div class="form-group has-success has-feedback">
    <label for="" class="control-label col-lg-1">has warning</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" placeholder="has-warning" value=""/>
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
    </div>
</div>

form-error-hint
===
<div class="form-group has-error has-feedback">
    <label for="" class="control-label col-lg-1">has-error</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" placeholder="has-error" value=""/>
        <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
        <span>验证失败</span>
    </div>
</div>

<div class="form-group has-success has-feedback">
    <label for="" class="control-label col-lg-1">has-success</label>
    <div class="col-lg-3">
        <div class="input-group">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control"/>
        </div>
        <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
        <span class="ar-only">验证成功</span>
    </div>
</div>

form-input-sm
===
<div class="form-group has-warning">
    <label for="" class="control-laebl col-lg-1">has-warning</label>
    <div class="col-lg-3">
        <input type="text" class="form-control input-sm" placeholder="has-warning" value=""/>
    </div>
</div>

form-input-lg
===
<div class="form-group has-success">
    <label for="" class="control-label col-lg-1">has-error</label>
    <div class="col-lg-3">
        <input type="text" class="input-lg form-control" placeholder="has-success" value=""/>
    </div>
</div>

form-group-lg
===
<div class="form-group form-group-lg">
    <label for="" class="control-label col-lg-1">has-warning</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" value=""/>
    </div>
</div>
form-group-sm
===
<div class="form-group form-group-sm">
    <label for="" class="control-label col-lg-1">has-error</label>
    <div class="col-lg-3">
        <input type="text" class="form-control" placeholder="has-error" value=""/>
    </div>
</div>
form-width
===

    <div class="row">
        <div class="col-sm-1">
            <input type="text" class="form-control" value="col-sm-1"/>
        </div>
        <div class="col-sm-2">
            <input type="text" class="form-control" value="col-sm-2"/>
        </div>
        <div class="col-sm-3">
            <input type="text" class="form-control" value="col-sm-3"/>
        </div>
        <div class="col-sm-4">
            <input type="text" class="form-control input-lg" value="col-sm-4"/>
        </div>
    </div>


button
===
<div class="container">
    <button class="btn">基础按钮</button>
    <a href="" class="btn" role="button">A标签按钮</a>
    <input type="button" class="btn" value="input按钮"/>
</div>

A-button
===
 <a href="" class="btn" role="button">A标签按钮</a>

button-default
===
<div class="container">
    <button class="btn btn-default">基础按钮</button>
    <a href="" class="btn btn-default" role="button">A标签按钮</a>
    <input type="button" class="btn btn-default" value="input按钮"/>
</div>
btn
===
<div class="container">
    <button class="btn btn-default">基础按钮</button>
    <a href="#" class="btn btn-default" role="button">A标签按钮</a>
    <input type="button" class="btn btn-default" value="input按钮"/>
    <span class="btn btn-default">span按钮</span>
    <div class="btn btn-default">div按钮</div>
    <input type="submit" class="btn btn-default" value="submit按钮"/>
    <input type="reset" class="btn btn-default" value="reset按钮"/>
</div>
btn-default
===
<div class="container">
    <button class="btn btn-default">btn-default</button>
    <button class="btn btn-primary">btn-primary</button>
    <button class="btn btn-success">btn-success</button>
    <button class="btn btn-info">btn-info</button>
    <button class="btn btn-warning">btn-warning</button>
    <button class="btn btn-danger">btn-danger</button>
    <button class="btn btn-link">btn-link</button>
</div>
btn-size
===
<div class="container">
    <button class="btn btn-primary">btn-primary</button>
    <button class="btn btn-primary btn-lg">btn-lg</button>
    <button class="btn btn-primary btn-lg">btn-primary</button>
    <button class="btn btn-primary btn-sm">btn-sm</button>
    <button class="btn btn-primary btn-xs">btn-xs</button>
</div>
btn-block
===
<div class="container">
    <button class="btn btn-primary btn-block">btn-primary</button>
    <button class="btn btn-primary btn-lg btn-block">btn-primary</button>
    <button class="btn btn-primary btn-sm btn-block">btn-primary</button>
    <button class="btn btn-primary btn-xs btn-block">btn-primary</button>
</div>
btn-hover
===
<div class="container">
    <button class="btn btn-default">btn-default</button>
    <button class="btn btn-default hover">btn-default</button>
    <button class="btn btn-default active">btn-default</button>
    <button class="btn btn-default focus">btn-default</button>
</div>
btn-disabled
===
<div class="container">
    <button class="btn btn-default disabled">btn-default</button>
    <button class="btn btn-default" disabled="disabled">btn-default</button>
    <a href="" class="btn btn-default disabled">btn-default</a>
</div>


