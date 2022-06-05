<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="chat_icon">
		<i class="fa fa-comments" aria-hidden="ture"></i>
</div>
<div class="chat_box">
	<div class="conv-form-wrapper">
		<form action="" method="GET" class="hidden">
			<select name="todo" data-conv-question="안녕! ${login.name} 무엇을 도와줄까?">
				<option value="dailyChallenge">일일 챌린지 도전</option>
				<option value="dailyData">일일 체크</option>
				<option value="moodState">기분 상태</option>
			</select>
			<div data-conv-fork="todo">
				<div data-conv-case="dailyChallenge">
					<select name="try" data-conv-question="오늘의 챌린지는 ~야!">
						<option id="go" value="go">도전하기</option>
						<option value="cancel">나중에하기</option>
					</select>
					<div data-conv-fork="cancel">
						<input type="text" data-conv-question="그래 다음에 도전하자!">
					</div>
				</div>
				<div data-conv-case="dailyData">
					<input type="text" data-conv-question="멋져부러" data-no-answer="true">
				</div>
				<div data-conv-case="moodState">
 					<input type="text" data-conv-question="멋져부러" data-no-answer="true">
				</div>
			</div>
		</form>
	</div>
</div>