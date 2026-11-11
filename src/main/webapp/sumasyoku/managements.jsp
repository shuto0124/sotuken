<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:import url="/common/base.jsp">
    <c:param name="title" >学食システム</c:param>
    <c:param name="scripts"></c:param>
    <c:param name="content">
      <div class="d-flex justify-content-end px-4 mt-3">
          <a href="Logout.action" class="btn btn-danger">ログアウト</a>
      </div>
      

        <section>
            <h2 class="fw-bold h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4 text-center">管理</h2>
            <div class="d-flex flex-column text-center px-4 fs-3 my-5">
                <div class="col d-flex align-items-center justify-content-center mx-2 my-4  ">
                    <a href="UserList.action" class="btn btn-primary btn-lg w-75 py-4">ユーザー管理</a>
                </div>
                <div class="col d-flex align-items-center justify-content-center mx-2 my-4 ">
	                        <a href="" class="btn btn-primary btn-lg w-75 py-4">商品管理</a>
                </div>
                <div class="col d-flex align-items-center justify-content-center mx-2 my-4 ">
                    <a href="" class="btn btn-primary btn-lg w-75 py-4">利用時間管理</a>
                </div>
                <div class="col d-flex align-items-center justify-content-center mx-2 my-4">
                    <a href="TableList.action" class="btn btn-primary btn-lg w-75 py-4">テーブル管理</a>
                </div>
                <div class="col d-flex align-items-center justify-content-center mx-2 my-4">
                    <a href="" class="btn btn-primary btn-lg w-75 py-4">予約一覧</a>
                </div>
            </div>
        </section>
    </c:param>
</c:import>