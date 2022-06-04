<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/narangnorang/js/common/norang2.js"></script>
<button type="button" onclick="openNorang()">노랑이</button>
<div id="norang" style="display: none;">
	<div>
		<button onclick="openDailyLog()">일일데이터</button>
	</div>
	<div>
		<button onclick="openMoodState()">기분상태</button>
	</div>
	<form id="dailyLog" style="display: none;">
		<div id="sleep">
			<div>몇 시간 잤어?</div>
			<input type="number" name="sleep" min="0" max="24" required="required">
		</div>
		<div id="medicine">
			<div>약은 먹었어?</div>
			<input type="radio" name="medicine" value="0">
			<input type="radio" name="medicine" value="1">
		</div>
		<button type="button" onclick="submitDailyLog()">전송</button>
	</form>
	<form id="moodState" style="display: none;">
		<div id="state">
			<div>지금 기분은 몇 점이야?</div>
			<input type="number" name="state" min="0" max="24" required="required">
		</div>
		<button type="button" onclick="submitMoodState()">전송</button>
	</form>
</div>