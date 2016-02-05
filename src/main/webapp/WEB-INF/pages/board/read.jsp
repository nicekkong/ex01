<%--
  Created by IntelliJ IDEA.
  User: nicekkong
  Date: 2016. 2. 2.
  Time: 오후 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">READ BOARD</h3>
                </div>
                <!-- /.box-header -->

                <form role="form" method="post">

                    <input type='hidden' name='bno' value="${board.bno}">

                </form>

                <div class="box-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Title</label> <input type="text"
                                                                             name='title' class="form-control" value="${board.title}"
                                                                             readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Content</label>
		                <textarea class="form-control" name="content" rows="3" readonly="readonly">${board.content}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Writer</label> <input type="text"
                                                                              name="writer" class="form-control" value="${board.writer}"
                                                                              readonly="readonly">
                    </div>
                </div>
                <!-- /.box-body -->

                <div class="box-footer">
                    <button type="submit" class="btn btn-warning">수정</button>
                    <button type="submit" class="btn btn-danger">삭제</button>
                    <button type="submit" class="btn btn-primary">전체 목록</button>
                </div>


                <script>

                    $(document).ready(function(){

                        var formObj = $("form[role='form']");

                        console.log(formObj);

                        $(".btn-warning").on("click", function(){
                            formObj.attr("action", "/board/modify");
                            formObj.attr("method", "get");
                            formObj.submit();
                        });

                        $(".btn-danger").on("click", function(){

                            if(confirm("해당 글을 정말 삭제 하시겠습니까?")) {
                                formObj.attr("action", "/board/remove");
                                formObj.submit();
                            }
                        });

                        $(".btn-primary").on("click", function(){
                            self.location = "/board/listAll";
                        });

                    });

                </script>

            </div>
            <!-- /.box -->
        </div>
        <!--/.col (left) -->

    </div>
    <!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
