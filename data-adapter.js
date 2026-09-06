
(function(){
  function cfg(){return window.GANI_CONFIG||{}}
  async function request(path,options={}){
    const base=(cfg().API_BASE_URL||"").replace(/\/$/,"");
    if(!base) throw new Error("PRODUCTION_API_NOT_CONFIGURED");
    const r=await fetch(base+path,{credentials:"include",headers:{"Accept":"application/json",...(options.headers||{})},...options});
    if(!r.ok) throw new Error("HTTP_"+r.status);
    return r.status===204?null:r.json();
  }
  window.GANI_DATA={
    isProductionConfigured(){return !!cfg().API_BASE_URL},
    profile(){return this.isProductionConfigured()?request("/api/v1/me"):GANI_MOCK_API.getProfile()},
    accounts(){return this.isProductionConfigured()?request("/api/v1/accounts"):GANI_MOCK_API.getAccounts()},
    notifications(){return this.isProductionConfigured()?request("/api/v1/notifications"):GANI_MOCK_API.getNotifications()}
  };
})();
