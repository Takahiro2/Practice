<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSトップ</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- BootstrapのCSS読み込み -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- jQuery読み込み -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- BootstrapのJS読み込み -->
        <script src="js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="freebirdFormviewerViewFormBanner freebirdHeaderMast"></div>
        <div class="container" align="center">
            <!-- Content here -->
            <div class="alert alert-success" role="alert">
                ユーザー情報管理トップ<br>
            </div>
            <h3>ここではユーザー情報の登録や検索、<br>
                付随して修正や削除を行うことができます</h3><br>
            <a href="insert">新規登録</a><br>
            <a href="Search">検索(修正・削除)</a><br>

            <div class="flex-container">
                <div class="item">Item 1</div>
                <div class="item">Item 2</div>
                <div class="item">Item 3</div>
                <div class="item">Item 4</div>
            </div>
        </div>
    </body>
</html>
