// pdf 파일 경로 
var url = '/resources/Portfolio.pdf';

var pdfjsLib = window['pdfjs-dist/build/pdf'];

pdfjsLib.GlobalWorkerOptions.workerSrc = '//mozilla.github.io/pdf.js/build/pdf.worker.js';

var pdfDoc = null,
 pageNum = 1,
 pageRendering = false,
 pageNumPending = null,
 scale = 0.8,
 canvas = null,
 ctx = null;

function renderPage(num) {
	pageRendering = true;

	pdfDoc.getPage(num).then(function(page) {
		 var viewport = page.getViewport({scale: scale});
		 canvas.height = viewport.height;
		 canvas.width = viewport.width;
	 
	 var renderContext = {
	   canvasContext: ctx,
	   viewport: viewport
	 };
	 
	 var renderTask = page.render(renderContext);
	 
	 renderTask.promise.then(function() {
	   pageRendering = false;
	   if (pageNumPending !== null) {
	     renderPage(pageNumPending);
	     pageNumPending = null;
	   }
	 });
	});
	
}

function queueRenderPage(num) {
	if (pageRendering) {
	 pageNumPending = num;
	} else {
	 renderPage(num);
	}
}

/**
* Displays previous page.
*/
function onPrevPage() {
	if (pageNum <= 1) {
	 return;
	}
	pageNum--;
	queueRenderPage(pageNum);
}
/**
* Displays next page.
*/
function onNextPage() {
	if (pageNum >= pdfDoc.numPages) {
	 return;
	}
	pageNum++;
	queueRenderPage(pageNum);
}

$(document).ready(function() {
	 canvas = document.getElementById('the-canvas'),
	 ctx = canvas.getContext('2d');
	 document.getElementById('prev').addEventListener('click', onPrevPage);
	 document.getElementById('next').addEventListener('click', onNextPage);
	 
	 pdfjsLib.getDocument(url).promise.then(function(pdfDoc_) {
			pdfDoc = pdfDoc_;
			// Initial/first page rendering
			renderPage(pageNum);
		});
});