$(function() {
	$('.el-name').click(toggleElValue);
});

function toggleElValue() {
	$('.el-value', this).toggle();
}