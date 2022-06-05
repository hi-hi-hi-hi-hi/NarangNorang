$(document).ready(function() {
	$.ajax({
		url : location.href,
		type : 'POST',
		data : {},
		datatype : "json",
		success : function(moodStateList) {
			draw(moodStateList);
		},
		error : function(xhr, status, e) {
			console.log(xhr, status, e);
		}
	});
});

function draw(moodStateList) {

	const data = moodStateList;
	console.log(data);

	const now = new Date();
	const xEnd = new Date(now.getTime());
	now.setDate(now.getDate() - 7);
	const xStart = now;
	const xScale = d3.scaleTime().domain([xStart, xEnd]).range([30, 730]);
	const yScale = d3.scaleLinear().domain([0, 100]).range([330, 30]);
	const xAxisSVG = d3.select("svg").append("g").attr("transform", "translate(0, 330)");
	const yAxisSVG = d3.select("svg").append("g");
	const xAxis = d3.axisBottom(xScale).tickSize(3).ticks(7);
	const yAxis = d3.axisRight(yScale).tickSize(3).ticks(10);
	xAxis(xAxisSVG);
	yAxis(yAxisSVG);

	d3.select("svg")
	.selectAll("circle")
	.data(data)
	.enter()
	.append("circle")
	.attr("r", 3)
	.attr("cx", d=>xScale(new Date(d.datetime)))
	.attr("cy", d=>yScale(d.state))
	.style("fill", "black");

	const linearGenerator = d3.line().x(d=>xScale(new Date(d.datetime))).y(d=>yScale(d.state));

	d3.select("svg")
	.append("path")
	.attr("d", linearGenerator(data))
	.attr("fill", "none")
	.attr("stroke-width", 1)
	.attr("stroke", "black");

}