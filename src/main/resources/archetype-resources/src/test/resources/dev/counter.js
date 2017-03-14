setTimeout(function(){ for(i=1; i< parent.document.querySelectorAll("body > div > section").length+1; i++){
    console.log(parent.document.querySelectorAll("body > div > section:nth-child("+i+") > details > section > details > summary > div > span.tag")['0'].innerHTML + ": " + parent.document.querySelectorAll("body > div > section:nth-child("+i+") > details > section > details > ol > li.skipped").length);
} }, 5000);

