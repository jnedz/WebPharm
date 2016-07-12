/*$('td', 'table').each(function(i) {
    $(this).text(i+1);
});

$('table.paginated').each(function() {
    var currentPage = 0;
    var numPerPage = 10;
    var $table = $(this);
    $table.bind('repaginate', function() {
        $table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
    });
    $table.trigger('repaginate');
    var numRows = $table.find('tbody tr').length;
    var numPages = Math.ceil(numRows / numPerPage);
    var $pager = $('<div class="pager"></div>');
    for (var page = 0; page < numPages; page++) {
        $('<span class="page-number"></span>').text(page + 1).bind('click', {
            newPage: page
        }, function(event) {
            currentPage = event.data['newPage'];
            $table.trigger('repaginate');
            $(this).addClass('active').siblings().removeClass('active');
        }).appendTo($pager).addClass('clickable');
    }
    $pager.insertBefore($table).find('span.page-number:first').addClass('active');
});
*/

function pagination(){
		var req_num_row=10;
		var $tr=jQuery('tbody tr');
		var total_num_row=$tr.length;
		var num_pages=0;
		if(total_num_row % req_num_row ==0){
			num_pages=total_num_row / req_num_row;
		}
		if(total_num_row % req_num_row >=1){
			num_pages=total_num_row / req_num_row;
			num_pages++;
			num_pages=Math.floor(num_pages++);
		}
		for(var i=1; i<=num_pages; i++){
			jQuery('#pagination').append(" "+i+" ");
		}
		$tr.each(function(i){
			jQuery(this).hide();
			if(i+1 <= req_num_row){
				$tr.eq(i).show();
			}
		
		});
		jQuery('#pagination a').click(function(e){
			e.preventDefault();
			$tr.hide();
			var page=jQuery(this).text();
			var temp=page-1;
			var start=temp*req_num_row;
			//alert(start);
			
			for(var i=0; i< req_num_row; i++){
				
				$tr.eq(start+i).show();
			
			}
		});
	}
jQuery('document').ready(function(){
	pagination();



});
