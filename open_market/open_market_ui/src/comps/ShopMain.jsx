import { Map, MapMarker } from "react-kakao-maps-sdk";
const ShopMain = () => {
  return (
    <div className="map">
      <Map
        center={{ lat: 35.155833, lng: 126.816667 }}
        style={{ width: "700px", height: "600px" }}
      >
        <MapMarker position={{ lat: 35.155833, lng: 126.816667 }}>
          {/* <div style={{ color: "#000" }}>푸른나라꽃나라</div> */}
        </MapMarker>
      </Map>
    </div>
  );
};

export default ShopMain;
