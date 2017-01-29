<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
			integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
			crossorigin="anonymous">
		
		<!-- Optional theme -->
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
			integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
			crossorigin="anonymous">
	
		<script type="text/javascript" src="./resources/js/lib/jquery-2.1.4.min.js"></script>
	
		<!-- Latest compiled and minified JavaScript -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
			integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
			crossorigin="anonymous"></script>
		
		<script type="text/javascript" src="./resources/js/lib/jquery.form.js"></script>
		<script type="text/javascript">
			$(function() {
				$('input:file[name=file]').change(function(event) {
					event.preventDefault();
					event.stopPropagation();
					var extension = $(this).val().replace(/^.*\./, '');
					if (extension == $(this).val()) {
				        extension = '';
				    } else {
				        extension = extension.toLowerCase();
				    }
					
					//이미지 파일은 JPG, PNG, BMP 확장자만 가능
					var avilableExtension = /(png|jpg|jpeg|bmp)/;
					if(!avilableExtension.test(extension)) {
						$(this).val("");
						alert("이미지 파일은 JPG, PNG, BMP 확장자만 가능합니다.");
					}
				});
				
				$('input:file[name=csv]').change(function(event) {
					event.preventDefault();
					event.stopPropagation();
					var extension = $(this).val().replace(/^.*\./, '');
					if (extension == $(this).val()) {
				        extension = '';
				    } else {
				        extension = extension.toLowerCase();
				    }
					
					//텍스트 파일은 CSV 확장자만 가능
					var avilableExtension = /(csv)/;
					if(!avilableExtension.test(extension)) {
						$(this).val("");
						alert("텍스트 파일은 CSV 확장자만 가능합니다.");
					}
				});
				
				$("#recipeForm").ajaxForm({
					beforeSubmit : function() {
						$('#loading').modal('show');
					},
					complete : function(xhr) {
						$('#loading').modal('hide');
						var result = xhr.responseText.replace(/<TEXTAREA>/gi, '').replace(/<\/TEXTAREA>/gi, '');
	                    result = $.parseJSON(result);
	                    if (result.code == 0) {
	                    	$('input:file[name=file]').val("");
	                    	$('input:file[name=csv]').val("");
							alert("업로드에 성공하였습니다");
						} else {
							switch (result.code) {
								case -18:
									alert("이미 업로드한 CSV 파일입니다");
									break;
								case -930:
									alert("CSV 파일이 존재하지 않습니다");
									break;
								case -931:
									alert("CSV 파일 형식이 아닙니다");
									break;
								case -950:
									alert("CSV 파일의 인코딩을 UTF-8로 변경해주시기 바랍니다");		
									break;
								defulat :
									alert("업로드에 실패하였습니다");
									break;
							}
							
						}
					}
				});
			});
		</script>
		<style>
			.sub_subject1, .sub_subject2 {
				line-height: 0.7;
			}
			.sub_subject3 {
				line-height: 0.5;
			}
			.sub_subject1 a, .sub_subject2 a, .sub_subject3 a {
				color: #000000;
				cursor: pointer;
				text-decoration: none;
				font-weight: bold;
			}
		</style>
	</head>
	<body>
		<div class="container center-block">
			<h2>레시피 업로드</h2>
			<h4 class="sub_subject1">작성 매뉴얼 : <a href="https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/manual/recipe_manual_v3.2.pdf" download="recipe_manual_v3.pdf">다운받기</a></h4>
			<h4 class="sub_subject2">카테고리 참조 : <a href="https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/manual/category.pdf" download="category.pdf">다운받기</a></h4>
			<h5 class="sub_subject3">샘플 파일 : <a href="https://s3.ap-northeast-2.amazonaws.com/proto-recipe/RECIPE/manual/recipe.0011.writer.xlsx" download="recipe.0011.writer.xlsx">다운받기</a></h5>
			<form id="recipeForm" class="row" method="post" action="/recipe/upload/recipe" enctype="multipart/form-data">
				<div class="form-group">
					<label for="file">이미지</label>
					<input type="file" name="file" accept="image/*">
					<p class="help-block">레시피 이미지를 선택해주세요.</p>
				</div>
				<div class="form-group">
					<label for="csv">CSV 파일</label>
					<input type="file" name="csv" accept="text/csv">
					<p class="help-block">CSV 파일을 선택해주세요.</p>
				</div>
				<input class="btn btn-primary" type="submit" value="저장" />
			</form>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="loading" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">등록 중입니다.</div>
				</div>
			</div>
		</div>
	</body>
</html>