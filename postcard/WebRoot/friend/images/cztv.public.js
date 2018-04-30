window.lib={version:"1.0",update:"2010/6/24"};$reg=function(g,c){var d=g.split("."),a=window;while(d.length>0){var b=d.shift();if(typeof a[b]=="undefined"){a[b]={}}a=a[b]}c()};
					Object.extend=function(b,a){
						for(var c in a){b[c]=a[c]}
						return b
					};
					var Class={
						create:function(){
							var f=function(){this.initialize.apply(this,arguments)};
							for(var b=0,a=arguments.length,d;b<a;b++){
								d=arguments[b];if(d==null){continue}
								Object.extend(f.prototype,d)
							}return f
						}
					};
					Object.extend(lib,(function(){
						var c={};
						var d=navigator.userAgent.toLowerCase();
						c.IE=/msie/.test(d);
						c.OPERA=/opera/.test(d);
						c.MOZ=/gecko/.test(d);
						c.IE6=/msie 6/.test(d);
						c.IE7=/msie 7/.test(d);
						c.IE8=/msie 8/.test(d);
						c.SAFARI=/safari/.test(d);
						c.winXP=/windows nt 5.1/.test(d);
						c.winVista=/windows nt 6.0/.test(d);
						c.CHROME=/chrome/.test(d);
						c.UC=/uc/.test(d);
						c.iphone=/iphone os/.test(d);
						c.ipod=/ipod\;/.test(d);
						c.android=/android/.test(d);
						c.iphone4=/iphone os 4_/.test(d);
						c.iphone5=/iphone os 5_/.test(d);	
						c.iphone6=/iphone os 6_/.test(d);
						c.iphone7=/iphone os 7_/.test(d);
						c.realIpad=/ipad/.test(d);
						c.ipad=c.realIpad||c.iphone5||c.iphone6||c.iphone7;
						c.Mac=/Macintosh/.test(d);
						c.TT=/tencenttraveler/.test(d);
						c.$360=/360se/.test(d);
						c.Maxthon=false;
						try{var a=window.external;c.Maxthon=a.max_version?true:false}
						catch(b){}
						c.getOS=function(){
							var g=navigator.userAgent;
							var i=(navigator.platform=="Win32")||(navigator.platform=="Windows");
							var k=(navigator.platform=="Mac68K")||(navigator.platform=="MacPPC")||(navigator.platform=="Macintosh");
							if(k){return"Mac"}
							var h=(navigator.platform=="X11")&&!i&&!k;
							if(h){return"Unix"}
							if(i){
								var l=g.indexOf("Windows NT 5.0")>-1||g.indexOf("Windows 2000")>-1;
								if(l){return"Win2000"}
								var f=g.indexOf("Windows NT 5.1")>-1||g.indexOf("Windows XP")>-1;
								if(f){return"WinXP"}
								var j=g.indexOf("Windows NT 5.2")>-1||g.indexOf("Windows 2003")>-1;
								if(j){return"Win2003"}
							}
							return"None"
						};
						c.getBr=function(){
							var i=navigator.userAgent.toLowerCase();
							var f=false;
							try{
								var g=window.external;
								f=g.max_version?true:false;
								if(f){
									return"傲游 "+g.max_version
								}
							}
							catch(h){}
							if(/msie/.test(i)){return i.match(/msie [\d.]+/)}
							if(/Firefox/i.test(i)){return"firefox "+i.match(/firefox\/([\d.]+)/)[1]}
							if(/360se/.test(i)){return"360"}
							if(/tencenttraveler/.test(i)){return"TT"}
							if(/chrome\/([\d.]+)/.test(i)){return i.match(/chrome\/[\d.]+/)}
							if(/safari/.test(i)){return i.match(/safari\/[\d.]+/)}
							if(/opera/.test(i)){return"opera"}
							return"非主流浏览器"
						};
						return c
					})());